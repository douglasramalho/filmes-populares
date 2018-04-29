package br.com.douglasmotta.filmespopulares.data.network;

import br.com.douglasmotta.filmespopulares.data.network.response.FilmesResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
