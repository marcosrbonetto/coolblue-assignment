package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * ShippingInfo model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "shippingInfo", strict = false)
public class ShippingInfo {

    @Element(name = "shippingType", required = false)
    private String shippingType;
    @Element(name = "shipToLocations", required = false)
    private String shipToLocations;

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getShipToLocations() {
        return shipToLocations;
    }

    public void setShipToLocations(String shipToLocations) {
        this.shipToLocations = shipToLocations;
    }
}
