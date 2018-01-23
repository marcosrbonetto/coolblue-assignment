package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "searchResult", strict = false)
public class SearchResult {

    @Attribute(name = "count", required = false)
    public String count;
    @ElementList(entry = "item", required = false, inline = true)
    public ArrayList<Item> item;
}
