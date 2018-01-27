package com.assignments.francisco.coolblueassignment.domain.interactors;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;

import javax.inject.Inject;

/**
 * Interactor responsable of retrieving products by category from data layer.
 *
 * @author Francisco Visintini
 */
public class GetProductsByCategory {

    //TODO This is not entirely accurate. Should have a Repository pattern that isolate data sources from interactors maybe with a Repository
    // Factory deciding whats best to use.
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
