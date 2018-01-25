package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "findItemsByKeywordsResponse", strict = false)
public class FindItemsByKeywordsResponse {

    @Element(name = "searchResult")
    private SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
