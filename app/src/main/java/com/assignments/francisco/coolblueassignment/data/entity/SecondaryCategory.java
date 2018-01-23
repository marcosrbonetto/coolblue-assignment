package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Element(name = "secondaryCategory")
public class SecondaryCategory {

    @Element(name = "categoryName", required = false)
    public String categoryName;
    @Element(name = "categoryId", required = false)
    public String categoryId;
}
