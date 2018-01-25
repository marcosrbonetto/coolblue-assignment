package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
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
