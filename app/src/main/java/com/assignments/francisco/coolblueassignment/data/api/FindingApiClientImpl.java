package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsByCategoryResponseEvent;
import com.assignments.francisco.coolblueassignment.data.model.mapper.ProductEntityDataMapper;
import com.squareup.otto.Bus;

import javax.inject.Inject;


/**
 * Created by fran on 22/01/18.
 */

public class FindingApiClientImpl extends FindingApi {

    private Bus bus;
    private FindingApiClient findingApiClient;
    private ProductEntityDataMapper productEntityDataMapper;

    @Inject
    public FindingApiClientImpl(FindingApiClient findingApiClient, Bus bus, ProductEntityDataMapper productEntityDataMapper) {
        this.findingApiClient = findingApiClient;
        this.bus = bus;
        this.productEntityDataMapper = productEntityDataMapper;
    }

    /**
     * Search products for a certain category.
     * Using default category. Of course, this is not the best approach. Should ask ebay for categories to show them al let the user choose which
     * one he would like to visualize.
     */
    public void getProductsByCategory() {
        findingApiClient.getProductsByCategory(GLOBAL_ID, APP_ID, VERSION, FIND_PRODUCTS_BY_CATEGORY_OPERATION_NAME,
                DATA_FORMAT, DEFAULT_PRODUCTS_CATEGORY).enqueue(new ProductCallback(
                new GetProductsByCategoryResponseEvent(), bus, productEntityDataMapper));
    }
}
