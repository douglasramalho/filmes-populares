package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import br.com.douglasmotta.filmespopulares.R;
import br.com.douglasmotta.filmespopulares.data.datamapper.FilmeDataMapper;
import br.com.douglasmotta.filmespopulares.data.model.Filme;
import br.com.douglasmotta.filmespopulares.data.network.ApiService;
import br.com.douglasmotta.filmespopulares.data.network.response.FilmesResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    private static final int LINEAR_LAYOUT_MANAGER = 0;
    private static final int GRID_LAYOUT_MANAGER = 1;

    RecyclerView recyclerFilmes;

    ListaFilmesAdapter listaFilmesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lista_filmes);

        configuraToolbar();
        configuraAdapter();
        obtemListaFilmes();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        listaFilmesAdapter = new ListaFilmesAdapter();

        recyclerFilmes = findViewById(R.id.recycler_filmes);
        recyclerFilmes.setLayoutManager(getLayoutManager(GRID_LAYOUT_MANAGER));
        recyclerFilmes.setAdapter(listaFilmesAdapter);
    }

    private RecyclerView.LayoutManager getLayoutManager(int layout) {
        if (layout == LINEAR_LAYOUT_MANAGER) {
            return new LinearLayoutManager(this);
        }

        return new GridLayoutManager(this, 2);
    }

    public void mostraErro(String mensagem) {
        Toast.makeText(ListaFilmesActivity.this, mensagem, Toast.LENGTH_LONG).show();
    }

    private void obtemListaFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares()
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeDataMapper.fromResponseToModel(response.body().getResultadoFilmes());
                            listaFilmesAdapter.adicionaFilmes(listaFilmes);
                        } else {
                            mostraErro("Erro: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        mostraErro(t.getMessage());
                    }
                });
    }
}
