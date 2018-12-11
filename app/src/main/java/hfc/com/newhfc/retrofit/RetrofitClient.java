package hfc.com.newhfc.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import hfc.com.newhfc.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static hfc.com.hfcnew.retrofit.ApiInterface getClient() {
        return retrofitBuilder().create(hfc.com.hfcnew.retrofit.ApiInterface.class);
    }



    public static Gson gson() {
        return new GsonBuilder().setDateFormat("yyyy-M  M-dd'T'HH:mm:ssZ").create();
    }

    private static OkHttpClient okHttp() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .build();
    }

    private static Retrofit retrofitBuilder() {
        return new Retrofit.Builder()
                .client(okHttp())
                .baseUrl(BuildConfig.API_BASEURL)
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .build();
    }


}