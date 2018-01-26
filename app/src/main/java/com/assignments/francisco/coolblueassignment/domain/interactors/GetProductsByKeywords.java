package com.assignments.francisco.coolblueassignment.domain.interactors;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */
public class GetProductsByKeywords {

    private FindingApiClientImpl findingApiClientImpl;

    @Inject
    public GetProductsByKeywords(FindingApiClientImpl findingApiClientImpl) {
        this.findingApiClientImpl = findingApiClientImpl;
    }


    public void execute(String keywords) {
        findingApiClientImpl.getProductsByKeywords(keywords);
    }

    public void execute(String keywords, String minPrice, String maxPrice) {
        findingApiClientImpl.getProductsByKeywords(keywords, minPrice, maxPrice);
    }
}
