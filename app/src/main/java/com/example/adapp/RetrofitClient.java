package com.example.adapp;




import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://run.mocky.io/";
    //  private static final String BASE_URL = "";
    private static Retrofit retrofit = null;

    public static ApiInterface getRetrofitClient() {

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpClient.addInterceptor(logging);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiInterface.class);
    }
}

