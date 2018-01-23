package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Element(name = "sellingStatus")
public class SellingStatus {

    @Element(name = "convertedCurrentPrice", required = false)
    public ConvertedCurrentPrice convertedCurrentPrice;
    @Element(name = "sellingState", required = false)
    public String sellingState;
    @Element(name = "timeLeft", required = false)
    public String timeLeft;
    @Element(name = "currentPrice", required = false)
    public CurrentPrice currentPrice;
}
