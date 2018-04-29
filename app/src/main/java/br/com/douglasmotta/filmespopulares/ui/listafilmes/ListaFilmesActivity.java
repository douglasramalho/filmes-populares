package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;
import java.util.List;

import br.com.douglasmotta.filmespopulares.R;
import br.com.douglasmotta.filmespopulares.data.model.Filme;
import br.com.douglasmotta.filmespopulares.data.network.ApiService;
import br.com.douglasmotta.filmespopulares.data.network.response.FilmesResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    RecyclerView recyclerFilmes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lista_filmes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerFilmes = findViewById(R.id.recycler_filmes);

        ApiService.getInstance()
                .obterFilmesPopulares("14eccca2f4f59c89f4ea7ed06fd384d1")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(ListaFilmesActivity.this);
                            recyclerFilmes.setLayoutManager(linearLayoutManager);
                            recyclerFilmes.setAdapter(new ListaFilmesAdapter(response.body().getResultadoFilmes()));
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {

                    }
                });
    }
}
