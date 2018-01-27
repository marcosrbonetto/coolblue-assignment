package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Response model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(strict = false)
public class ProductsResponse {

    @Element(name = "searchResult")
    private SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
