package com.assignments.francisco.coolblueassignment.domain.interactors;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */
public class GetProductsByCategory {

    private FindingApiClientImpl findingApiClientImpl;

    @Inject
    public GetProductsByCategory(FindingApiClientImpl findingApiClientImpl) {
        this.findingApiClientImpl = findingApiClientImpl;
    }

    /**
     * Executes get products by category use case for the default category.
     */
    public void execute() {
        findingApiClientImpl.getProductsByCategory();
    }

}
