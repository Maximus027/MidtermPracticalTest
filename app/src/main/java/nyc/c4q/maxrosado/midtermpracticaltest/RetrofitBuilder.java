package nyc.c4q.maxrosado.midtermpracticaltest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maxrosado on 12/10/16.
 */

public class RetrofitBuilder {

    private static final String someURL = "https://vine.co/";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder;


    public static ApiService makeService() {
        if (retrofit == null) {
            builder = new Retrofit.Builder()
                    .baseUrl(someURL)
                    .addConverterFactory(GsonConverterFactory.create());
        }
        retrofit = builder.build();
        return retrofit.create(ApiService.class);
    }
}
