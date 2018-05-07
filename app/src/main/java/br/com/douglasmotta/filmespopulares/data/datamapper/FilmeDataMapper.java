package br.com.douglasmotta.filmespopulares.data.datamapper;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasmotta.filmespopulares.data.model.Filme;
import br.com.douglasmotta.filmespopulares.data.network.response.FilmeResponse;

public class FilmeDataMapper {

    public static List<Filme> fromResponseToModel(List<FilmeResponse> listaFilmeResponse) {
        final List<Filme> listaFilme = new ArrayList<>();

        for (FilmeResponse filmeResponse : listaFilmeResponse) {
            listaFilme.add(toModel(filmeResponse));
        }

        return listaFilme;
    }

    private static Filme toModel(FilmeResponse filmeResponse) {
        return new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
    }
}
