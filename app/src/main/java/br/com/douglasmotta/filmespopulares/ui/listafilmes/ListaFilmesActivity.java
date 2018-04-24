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

public class ListaFilmesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_lista_filmes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerFilmes = findViewById(R.id.recycler_filmes);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerFilmes.setLayoutManager(linearLayoutManager);
        recyclerFilmes.setAdapter(new ListaFilmesAdapter(criaFilmes()));
    }

    private List<Filme> criaFilmes() {
        return Arrays.asList(
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro"),
            new Filme("Corações de ferro")
        );
    }
}
