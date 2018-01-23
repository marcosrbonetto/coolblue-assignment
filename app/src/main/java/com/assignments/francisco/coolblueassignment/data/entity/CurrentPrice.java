package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "currentPrice", strict = false)
public class CurrentPrice {

    @Element(name = "content", required = false)
    public String content;
    @Attribute(name = "currencyId", required = false)
    public String currencyId;
}
