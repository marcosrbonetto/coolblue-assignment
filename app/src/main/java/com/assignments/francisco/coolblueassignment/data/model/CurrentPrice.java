package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * CurrentPrice model class for ebay products response.
 *
 * @author Francisco Visintini
 */
@Root(name = "currentPrice", strict = false)
public class CurrentPrice {

    @Text
    private String text;

    @Attribute(name = "currencyId", required = false)
    private String currencyId;

    public String getPrice() {
        return text;
    }

    public void setPrice(String text) {
        this.text = text;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
}
