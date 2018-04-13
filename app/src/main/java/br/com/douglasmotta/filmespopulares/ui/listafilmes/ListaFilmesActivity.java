package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasmotta.filmespopulares.R;
import br.com.douglasmotta.filmespopulares.data.model.Filme;
import br.com.douglasmotta.filmespopulares.data.network.ApiService;
import br.com.douglasmotta.filmespopulares.data.network.responses.FilmesResponse;
import br.com.douglasmotta.filmespopulares.data.network.responses.ResultsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements ListaFilmesAdapter.OnFilmeClickListener {

    private RecyclerView recyclerFilmes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lista_filmes);
        configuraToolbar();

        configurarViews();

        ApiService.getInstance().obterFilmesPopulares("14eccca2f4f59c89f4ea7ed06fd384d1")
                .enqueue(new Callback<ResultsResponse>() {
                    @Override
                    public void onResponse(Call<ResultsResponse> call, Response<ResultsResponse> response) {
                        criarAdapter(obterListaFilmesDeResposta(response.body().getFilmesResponseList()));
                    }

                    @Override
                    public void onFailure(Call<ResultsResponse> call, Throwable t) {

                    }
                });
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void configurarViews() {
        recyclerFilmes = findViewById(R.id.recyclerFilmes);
    }

    private void criarAdapter(List<Filme> filmes) {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        ListaFilmesAdapter adapter = new ListaFilmesAdapter(filmes, this);
        recyclerFilmes.setHasFixedSize(true);
        recyclerFilmes.setLayoutManager(gridLayoutManager);
        recyclerFilmes.setAdapter(adapter);
    }

    private List<Filme> obterListaFilmesDeResposta(List<FilmesResponse> filmesResponseList) {
        List<Filme> filmes = new ArrayList<>();
        for (FilmesResponse filmesResponse : filmesResponseList) {
            Filme filme = new Filme(
                    filmesResponse.getCaminhoPoster(), filmesResponse.isAdulto(),
                    filmesResponse.getVisaoGeral(), filmesResponse.getDataLancamento(),
                    filmesResponse.getGenerosIds(), filmesResponse.getTitulo());

            filmes.add(filme);
        }

        return filmes;
    }

    @Override
    public void onClick(Filme filme) {

    }
}
