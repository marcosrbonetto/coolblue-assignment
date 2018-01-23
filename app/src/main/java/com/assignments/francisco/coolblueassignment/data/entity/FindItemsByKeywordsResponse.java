package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "findItemsByKeywordsResponse")
public class FindItemsByKeywordsResponse {

    @Element(name = "timestamp", required = false)
    public String timestamp;
    @Element(name = "searchResult")
    public SearchResult searchResult;
    @Element(name = "ack", required = false)
    public String ack;
    @Element(name = "paginationOutput", required = false)
    public PaginationOutput paginationOutput;
    @Element(name = "itemSearchURL", required = false)
    public String itemSearchURL;
    @Element(name = "xmlns", required = false)
    public String xmlns;
    @Element(name = "version", required = false)
    public String version;
}
