package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by fran on 23/01/18.
 */

@Element(name = "item")
public class Item {

    @Element(name = "listingInfo", required = false)
    public ListingInfo listingInfo;
    @Element(name = "primaryCategory", required = false)
    public PrimaryCategory primaryCategory;
    @Element(name = "secondaryCategory", required = false)
    public SecondaryCategory secondaryCategory;
    @Element(name = "condition", required = false)
    public Condition condition;
    @Element(name = "location", required = false)
    public String location;
    @Element(name = "topRatedListing", required = false)
    public String topRatedListing;
    @Element(name = "globalId", required = false)
    public String globalId;
    @Element(name = "itemId", required = false)
    public String itemId;
    @Element(name = "shippingInfo", required = false)
    public ShippingInfo shippingInfo;
    @Element(name = "viewItemURL", required = false)
    public String viewItemURL;
    @Element(name = "productId", required = false)
    public ProductId productId;
    @Element(name = "country", required = false)
    public String country;
    @Element(name = "galleryURL", required = false)
    public String galleryURL;
    @Element(name = "galleryPlusPictureURL", required = false)
    public String galleryPlusPictureURL;
    @Element(name = "autoPay", required = false)
    public String autoPay;
    @Element(name = "title", required = false)
    public String title;
    @Element(name = "subtitle", required = false)
    public String subtitle;
    @Element(name = "postalCode", required = false)
    public String postalCode;
    @Element(name = "returnsAccepted", required = false)
    public String returnsAccepted;
    @Element(name = "sellingStatus", required = false)
    public SellingStatus sellingStatus;
    @Element(name = "discountPriceInfo", required = false)
    public DiscountPriceInfo discountPriceInfo;
    @Element(name = "isMultiVariationListing", required = false)
    public String isMultiVariationListing;
    @Path("paymentMethod")
    @Text(required=false)
    public String paymentMethod;
}
