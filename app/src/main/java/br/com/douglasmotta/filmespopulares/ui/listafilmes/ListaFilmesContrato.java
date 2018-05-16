package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import java.util.List;

import br.com.douglasmotta.filmespopulares.data.model.Filme;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();
    }

    interface ListaFilmesPresenter {

        void obtemFilmes();

        void destruirView();
    }
}
