package com.ak681443.ilovezappos.util;

import android.util.Log;

import com.ak681443.ilovezappos.api.ZapposAPI;
import com.ak681443.ilovezappos.model.AutoCompleteResponse;
import com.ak681443.ilovezappos.model.ImageResponse;
import com.ak681443.ilovezappos.model.RecomendationResponse;
import com.ak681443.ilovezappos.model.SearchResponse;
import com.ak681443.ilovezappos.model.SearchResult;

import java.io.IOException;

import static com.ak681443.ilovezappos.util.Constants.*;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arvind on 2/8/17.
 */

public class ZAPIUtil {
    private static final String TAG = "ZAPI";

    private static  ZapposAPI zapi = null;
    private static Retrofit retrofitInstance;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static void initializeAPI(){
        if(zapi == null) {
            injectAuthenticationInterceptor(httpClient);
            builder.client(httpClient.build());
            retrofitInstance = builder.build();
            zapi = retrofitInstance.create(ZapposAPI.class);
        }
    }


    public static void performSearch(String term, Callback<SearchResponse> callback){
        zapi.searchProduct(term).enqueue(callback);
    }

    public static void getSimilarProducts(SearchResult originalProduct, Callback<RecomendationResponse> callback){
        zapi.getSimilarProducts(originalProduct, "brandName").enqueue(callback);
    }

    public static void doAutoComplete(String term, Callback<AutoCompleteResponse> callback){
        zapi.autoCompleteTerm(term).enqueue(callback);
    }

    public static void fetchThumbnails(String productId, Callback<ImageResponse> callback){
        zapi.getImages(productId).enqueue(callback);
    }

    public static SearchResponse doAutoCompleteSync(String term) throws IOException{
        return zapi.searchProduct(term).execute().body();
    }

    private static void injectAuthenticationInterceptor(OkHttpClient.Builder httpClient){
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request interceptedRequest = chain.request();
                HttpUrl url = interceptedRequest.url();
                url = url.newBuilder().addQueryParameter("key", API_KEY).build();
                Request newRequest = interceptedRequest.newBuilder().url(url).build();
                return chain.proceed(newRequest);
            }
        });
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
    }
}
