package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Ebay finding API client interface. Contains all calls made to that endpoint.
 *
 * @author Francisco Visintini
 */
public interface FindingApiClient {

    /**
     * Forms a call for getProductsByCategory operation.
     *
     * @param globalId Store id. Default is EBAY-US
     * @param category products category to retrieve
     *
     * @return formed Call<ProductResponse> object to perform.
     */
    @GET("services/search/FindingService/v1/?SECURITY-APPNAME=Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb" +
            "&SERVICE-VERSION=1.13.0&RESPONSE-DATA-FORMAT=XML&OPERATION-NAME=findItemsByCategory")
    Call<ProductsResponse> getProductsByCategory(@Query("GLOBAL-ID") String globalId, @Query("categoryId") int category);

    /**
     * Forms a call for getProductsByKeywords operation.
     *
     * @param globalId Store id. Default is EBAY-US
     * @param keywords keywords typed by the user to search.
     *
     * @return formed Call<ProductResponse> object to perform.
     */
    @GET("services/search/FindingService/v1/?SECURITY-APPNAME=Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb" +
            "&SERVICE-VERSION=1.13.0&RESPONSE-DATA-FORMAT=XML&OPERATION-NAME=findItemsByKeywords")
    Call<ProductsResponse> getProductsByKeywords(@Query("GLOBAL-ID") String globalId, @Query("keywords") String keywords);

    /**
     * Forms a call for getProductsByKeywords operation with price filters.
     *
     * @param globalId Store id. Default is EBAY-US
     * @param keywords keywords typed by the user to search.
     * @param minPrice minimum price filter
     * @param maxPrice maximum price filter
     *
     * @return formed Call<ProductResponse> object to perform.
     */
    @GET("services/search/FindingService/v1/?SECURITY-APPNAME=Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb" +
            "&SERVICE-VERSION=1.13.0&RESPONSE-DATA-FORMAT=XML&OPERATION-NAME=findItemsByKeywords")
    Call<ProductsResponse> getProductsByKeywords(@Query("GLOBAL-ID") String globalId, @Query("keywords") String keywords,
            @Query("itemFilter(0).name") String minPriceLabel, @Query("itemFilter(0).value") String minPrice,
            @Query("itemFilter(1).name") String maxPriceLabel, @Query("itemFilter(1).value") String maxPrice);
}
