package com.assignments.francisco.coolblueassignment.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by fran on 23/01/18.
 */

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "primaryCategory", required = false)
    private PrimaryCategory primaryCategory;

    @Element(name = "condition", required = false)
    private Condition condition;

    @Element(name = "location", required = false)
    private String location;

    @Element(name = "shippingInfo", required = false)
    private ShippingInfo shippingInfo;

    @Element(name = "galleryURL", required = false)
    private String galleryURL;

    @Element(name = "galleryPlusPictureURL", required = false)
    private String galleryPlusPictureURL;

    @Element(name = "title", required = false)
    private String title;

    @Element(name = "subtitle", required = false)
    private String subtitle;

    @Element(required = false)
    private SellingStatus sellingStatus;

    public PrimaryCategory getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(PrimaryCategory primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getGalleryURL() {
        return galleryURL;
    }

    public void setGalleryURL(String galleryURL) {
        this.galleryURL = galleryURL;
    }

    public String getGalleryPlusPictureURL() {
        return galleryPlusPictureURL;
    }

    public void setGalleryPlusPictureURL(String galleryPlusPictureURL) {
        this.galleryPlusPictureURL = galleryPlusPictureURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public SellingStatus getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(SellingStatus sellingStatus) {
        this.sellingStatus = sellingStatus;
    }
}
