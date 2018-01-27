package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * PrimaryCategory model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "primaryCategory", strict = false)
public class PrimaryCategory {

    @Element(name = "categoryName", required = false)
    private String categoryName;
    @Element(name = "categoryId", required = false)
    private String categoryId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
