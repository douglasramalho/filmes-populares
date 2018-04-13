package br.com.douglasmotta.filmespopulares.data.network.responses;

import com.squareup.moshi.Json;

import java.util.List;

public class ResultsResponse {

    @Json(name = "results")
    private final List<FilmesResponse> filmesResponseList;

    @Json(name = "page")
    private final int pagina;

    @Json(name = "total_results")
    private final int totalResultados;

    @Json(name = "total_pages")
    private final int totalPaginas;

    public ResultsResponse(List<FilmesResponse> filmesResponseList, int pagina, int totalResultados, int totalPaginas) {
        this.filmesResponseList = filmesResponseList;
        this.pagina = pagina;
        this.totalResultados = totalResultados;
        this.totalPaginas = totalPaginas;
    }

    public List<FilmesResponse> getFilmesResponseList() {
        return filmesResponseList;
    }

    public int getPagina() {
        return pagina;
    }

    public int getTotalResultados() {
        return totalResultados;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }
}
