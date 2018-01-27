package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * SearchResult model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "searchResult", strict = false)
public class SearchResult {

    @Attribute(name = "count")
    private String count;

    @ElementList(entry = "item", required = false, inline = true)
    private ArrayList<Item> products;

    public ArrayList<Item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Item> item) {
        this.products = item;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
