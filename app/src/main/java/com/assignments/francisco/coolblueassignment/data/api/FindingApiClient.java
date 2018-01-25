package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.data.model.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fran on 22/01/18.
 */

public interface FindingApiClient {

    @GET("services/search/FindingService/v1/?SECURITY-APPNAME=Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb" +
            "&SERVICE-VERSION=1.13.0&RESPONSE-DATA-FORMAT=XML&OPERATION-NAME=findItemsByCategory")
    Call<ProductsResponse> getProductsByCategory(@Query("GLOBAL-ID") String globalId, @Query("categoryId") int category);

    @GET("services/search/FindingService/v1/?SECURITY-APPNAME=Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb" +
            "&SERVICE-VERSION=1.13.0&RESPONSE-DATA-FORMAT=XML&OPERATION-NAME=findItemsByKeywords")
    Call<ProductsResponse> getProductsByKeywords(@Query("GLOBAL-ID") String globalId, @Query("keywords") String keywords);
}
