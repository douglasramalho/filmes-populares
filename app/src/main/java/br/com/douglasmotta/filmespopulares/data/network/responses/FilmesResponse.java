package br.com.douglasmotta.filmespopulares.data.network.responses;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmesResponse {

    @Json(name = "poster_path")
    private final String caminhoPoster;

    @Json(name = "adult")
    private final boolean adulto;

    @Json(name = "overview")
    private final String visaoGeral;

    @Json(name = "release_date")
    private final String dataLancamento;

    @Json(name = "genre_ids")
    private final List<Integer> generosIds;

    @Json(name = "title")
    private final String titulo;

    public FilmesResponse(String caminhoPoster, boolean adulto, String visaoGeral, String dataLancamento, List<Integer> generosIds, String titulo) {
        this.caminhoPoster = caminhoPoster;
        this.adulto = adulto;
        this.visaoGeral = visaoGeral;
        this.dataLancamento = dataLancamento;
        this.generosIds = generosIds;
        this.titulo = titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public boolean isAdulto() {
        return adulto;
    }

    public String getVisaoGeral() {
        return visaoGeral;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public List<Integer> getGenerosIds() {
        return generosIds;
    }

    public String getTitulo() {
        return titulo;
    }
}
