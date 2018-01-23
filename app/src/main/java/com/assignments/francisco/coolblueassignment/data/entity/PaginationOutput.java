package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Element(name = "paginationOutput")
public class PaginationOutput {

    @Element(name = "pageNumber", required = false)
    public String pageNumber;
    @Element(name = "entriesPerPage", required = false)
    public String entriesPerPage;
    @Element(name = "totalEntries", required = false)
    public String totalEntries;
    @Element(name = "totalPages", required = false)
    public String totalPages;
}
