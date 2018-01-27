package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * SellingStatus model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "sellingStatus", strict = false)
public class SellingStatus {

    @Element(name = "currentPrice", required = false)
    private CurrentPrice currentPrice;

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }
}
