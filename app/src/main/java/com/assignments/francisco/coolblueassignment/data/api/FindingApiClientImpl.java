package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsByCategoryResponseEvent;
import com.assignments.francisco.coolblueassignment.data.model.mapper.ProductDataMapper;
import com.squareup.otto.Bus;

import javax.inject.Inject;


/**
 * Created by fran on 22/01/18.
 */

public class FindingApiClientImpl extends FindingApi {

    private Bus bus;
    private FindingApiClient findingApiClient;
    private ProductDataMapper productDataMapper;

    @Inject
    public FindingApiClientImpl(FindingApiClient findingApiClient, Bus bus, ProductDataMapper productDataMapper) {
        this.findingApiClient = findingApiClient;
        this.bus = bus;
        this.productDataMapper = productDataMapper;
    }

    /**
     * Search products for a certain category.
     * Using default category. Of course, this is not the best approach. Should ask ebay for categories to show them al let the user choose which
     * one he would like to visualize.
     */
    public void getProductsByCategory() {
        findingApiClient.getProductsByCategory(DEFAULT_GLOBAL_ID, DEFAULT_PRODUCTS_CATEGORY)
                        .enqueue(new ProductCallback(new GetProductsByCategoryResponseEvent(), bus, productDataMapper));
    }
}
