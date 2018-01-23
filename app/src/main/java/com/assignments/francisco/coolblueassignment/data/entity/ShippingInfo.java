package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Element(name = "shippingInfo")
public class ShippingInfo {

    @Element(name = "shippingType", required = false)
    public String shippingType;
    @Element(name = "shipToLocations", required = false)
    public String shipToLocations;
    @Element(name = "shippingServiceCost", required = false)
    public ShippingServiceCost shippingServiceCost;
    @Element(name = "expeditedShipping", required = false)
    public String expeditedShipping;
    @Element(name = "handlingTime", required = false)
    public String handlingTime;
    @Element(name = "oneDayShippingAvailable", required = false)
    public String oneDayShippingAvailable;
}
