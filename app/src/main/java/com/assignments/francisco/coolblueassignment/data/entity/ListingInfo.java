package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */
@Root(name = "listingInfo", strict = false)
public class ListingInfo {

    @Element(name = "startTime", required = false)
    public String startTime;
    @Element(name = "gift", required = false)
    public String gift;
    @Element(name = "bestOfferEnabled", required = false)
    public String bestOfferEnabled;
    @Element(name = "buyItNowAvailable", required = false)
    public String buyItNowAvailable;
    @Element(name = "listingType", required = false)
    public String listingType;
    @Element(name = "watchCount", required = false)
    public String watchCount;
    @Element(name = "endTime", required = false)
    public String endTime;
}
