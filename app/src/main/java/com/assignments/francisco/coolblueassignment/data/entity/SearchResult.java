package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by fran on 23/01/18.
 */
@Element(name = "searchResult")
public class SearchResult {

    @Attribute(name = "count")
    public String count;
    @ElementList(name = "item", inline = true)
    public List<Item> item;
}
