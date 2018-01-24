package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.entity.FindItemsByKeywordsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fran on 22/01/18.
 */

public interface FindingApiClient {

    @GET("services/search/FindingService/v1/")
    Call<FindItemsByKeywordsResponse> getProductsByCategory(@Query("GLOBAL-ID") String globalId,
            @Query("SECURITY-APPNAME") String appId, @Query("SERVICE-VERSION") String version,
            @Query("OPERATION-NAME") String operationName, @Query("RESPONSE-DATA-FORMAT") String dataFormat,
            @Query("categoryId") int category);
}
