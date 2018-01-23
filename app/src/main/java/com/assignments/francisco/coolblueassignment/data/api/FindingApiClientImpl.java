package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.event.GetProductsResponseEvent;

import javax.inject.Inject;


/**
 * Created by fran on 22/01/18.
 */

public class FindingApiClientImpl {

    public static final String APP_ID = "Francisc-CoolBlue-PRD-a5d80d3bd-d45ab8cb";
    private FindingApiClient findingApiClient;

    @Inject
    public FindingApiClientImpl(FindingApiClient findingApiClient) {
        this.findingApiClient = findingApiClient;
    }

    public void getProducts() {
        findingApiClient.getProductsByFilter("EBAY-US", APP_ID, "1.13.0", "findItemsByKeywords",
                "XML", "harry potter".replace("+", "%20"), 50).enqueue(new ProductCallback(new GetProductsResponseEvent()));
    }
}
