package com.ak681443.ilovezappos.api;

import com.ak681443.ilovezappos.model.AutoCompleteResponse;
import com.ak681443.ilovezappos.model.RecomendationResponse;
import com.ak681443.ilovezappos.model.SearchResponse;
import com.ak681443.ilovezappos.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arvind on 2/8/17.
 */

public interface ZapposAPI {

    @GET("/Search")
    Call<SearchResponse> searchProduct(@Query("term") String searchTerm);

    @GET("/Search/Similarity?limit=10&type=moreLikeThis")
    Call<RecomendationResponse> getSimilarProducts(@Query("styleId") SearchResult originalProduct,
                                                   @Query("emphasis") String emphasis);

    @GET("/AutoComplete")
    Call<AutoCompleteResponse> autoCompleteTerm(@Query("term") String searchTerm);

}
