package br.com.douglasmotta.filmespopulares.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static TheMovieDBApi INSTANCE;

    private ApiService() {
    }

    public static TheMovieDBApi getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create(TheMovieDBApi.class);
        }

        return INSTANCE;
    }
}
