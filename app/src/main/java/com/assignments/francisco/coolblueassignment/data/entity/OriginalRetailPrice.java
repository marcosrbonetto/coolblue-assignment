package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "originalRetailPrice", strict = false)
public class OriginalRetailPrice {

    @Element(name = "content", required = false)
    public String content;
    @Attribute(name = "currencyId", required = false)
    public String currencyId;
}
