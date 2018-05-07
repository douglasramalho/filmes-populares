package br.com.douglasmotta.filmespopulares.data.network;

import android.os.Build;
import android.util.Log;

import java.io.IOException;

import br.com.douglasmotta.filmespopulares.BuildConfig;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static FilmesService INSTANCE;

    public static FilmesService getInstance() {

        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(getClient())
                    .build();

            INSTANCE = retrofit.create(FilmesService.class);
        }

        return INSTANCE;
    }

    private static OkHttpClient getClient() {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(createLoggingInterceptor());
        }

        clientBuilder.addInterceptor(createTokenInterceptor());

        return clientBuilder.build();
    }

    private static HttpLoggingInterceptor createLoggingInterceptor() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    private static Interceptor createTokenInterceptor() {

        Interceptor tokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl httpUrl = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", "14eccca2f4f59c89f4ea7ed06fd384d1")
                        .build();

                request = request.newBuilder().url(httpUrl).build();

                return chain.proceed(request);
            }
        };

        return tokenInterceptor;
    }
}
