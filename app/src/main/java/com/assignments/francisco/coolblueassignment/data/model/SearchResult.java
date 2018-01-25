package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "searchResult", strict = false)
public class SearchResult {

    @ElementList(entry = "item", required = false, inline = true)
    private ArrayList<Item> products;

    public ArrayList<Item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Item> item) {
        this.products = item;
    }
}
