package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import static com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent.CATEGORY_TYPE;
import static com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent.KEYWORDS_TYPE;


/**
 * API client to use with ebay finding API.
 *
 * @author Francisco Visintini
 */
public class FindingApiClientImpl {
    public static final int DEFAULT_PRODUCTS_CATEGORY = 9355;//Cell Phones & Smartphones category.
    public static final String DEFAULT_GLOBAL_ID = "EBAY-US";
    public static final String MIN_PRICE_FILTER = "MinPrice";
    public static final String MAX_PRICE_FILTER = "MaxPrice";

    private Bus bus;
    private FindingApiClient findingApiClient;

    @Inject
    public FindingApiClientImpl(FindingApiClient findingApiClient, Bus bus) {
        this.findingApiClient = findingApiClient;
        this.bus = bus;
    }

    /**
     * Search products for a certain category.
     */
    public void getProductsByCategory() {
        //TODO Using default category. This is not the best approach.
        // Should be asking for ebay categories to show them and let the user choose which
        // one he would like to visualize. And maybe we also could have an Injected Factory that
        // creates appropiate ProductCallbacks

        findingApiClient.getProductsByCategory(DEFAULT_GLOBAL_ID, DEFAULT_PRODUCTS_CATEGORY)
                        .enqueue(new ProductCallback(new GetProductsResponseEvent(CATEGORY_TYPE), bus));
    }

    /**
     * Search products based on keywords typed by the user.
     *
     * @param keywords
     */
    public void getProductsByKeywords(String keywords) {
        findingApiClient.getProductsByKeywords(DEFAULT_GLOBAL_ID, keywords)
                        .enqueue(new ProductCallback(new GetProductsResponseEvent(KEYWORDS_TYPE), bus));
    }

    /**
     * Search products based on keywords typed by the user.
     *
     * @param keywords
     */
    public void getProductsByKeywords(String keywords, String minPrice, String maxPrice) {
        findingApiClient.getProductsByKeywords(DEFAULT_GLOBAL_ID, keywords, MIN_PRICE_FILTER, minPrice, MAX_PRICE_FILTER, maxPrice)
                        .enqueue(new ProductCallback(new GetProductsResponseEvent(KEYWORDS_TYPE), bus));
    }
}
