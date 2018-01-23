package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */

@Root(name = "discountPriceInfo", strict = false)
public class DiscountPriceInfo {

    @Element(name = "pricingTreatment", required = false)
    public String pricingTreatment;
    @Element(name = "soldOnEbay", required = false)
    public String soldOnEbay;
    @Element(name = "soldOffEbay", required = false)
    public String soldOffEbay;
    @Element(name = "originalRetailPrice", required = false)
    public OriginalRetailPrice originalRetailPrice;
}
