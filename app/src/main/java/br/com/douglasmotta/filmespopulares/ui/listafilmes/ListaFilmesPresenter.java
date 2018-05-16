package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import java.util.List;

import br.com.douglasmotta.filmespopulares.data.mapper.FilmeMapper;
import br.com.douglasmotta.filmespopulares.data.model.Filme;
import br.com.douglasmotta.filmespopulares.data.network.ApiService;
import br.com.douglasmotta.filmespopulares.data.network.response.FilmesResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("14eccca2f4f59c89f4ea7ed06fd384d1")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Filme> listaFilmes = FilmeMapper
                                    .deResponseParaDominio(response.body().getResultadoFilmes());

                            view.mostraFilmes(listaFilmes);
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
