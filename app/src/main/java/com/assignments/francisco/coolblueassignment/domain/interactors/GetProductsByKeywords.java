package com.assignments.francisco.coolblueassignment.domain.interactors;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;

import javax.inject.Inject;

/**
 * Interactor responsible of retrieving products by keywords from data layer with or without filters.
 *
 * @author Francisco Visintini
 */
public class GetProductsByKeywords {

    //TODO This is not entirely accurate. Should have a Repository pattern that isolate data sources from interactors maybe with a Repository
    // Factory deciding whats best to use.
    private FindingApiClientImpl findingApiClientImpl;

    @Inject
    public GetProductsByKeywords(FindingApiClientImpl findingApiClientImpl) {
        this.findingApiClientImpl = findingApiClientImpl;
    }

    /**
     * Executes get products by keywords.
     *
     * @param keywords keywords to search.
     */
    public void execute(String keywords) {
        findingApiClientImpl.getProductsByKeywords(keywords);
    }

    /**
     * Executes get products by keywords with price filters.
     *
     * @param keywords keywords to search.
     * @param minPrice minimum price filter
     * @param maxPrice maximum price filter
     */
    //TODO This shouldn't be done like this. In a typical app we would have lots of filters with their corresponding Filter models.
    // Maybe this should receive a Map or Array of filters?
    public void execute(String keywords, String minPrice, String maxPrice) {
        findingApiClientImpl.getProductsByKeywords(keywords, minPrice, maxPrice);
    }
}
