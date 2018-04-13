package br.com.douglasmotta.filmespopulares.data.network;

import br.com.douglasmotta.filmespopulares.data.network.responses.ResultsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDBApi {

    @GET("movie/popular")
    Call<ResultsResponse> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
