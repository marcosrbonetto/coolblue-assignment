package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "productId", strict = false)
public class ProductId {

    @Element(name = "content", required = false)
    public String content;
    @Attribute(name = "type", required = false)
    public String type;
}
