package com.assignments.francisco.coolblueassignment.data.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

/**
 * Created by fran on 23/01/18.
 */

@Root
public class Item {

    @Element(name = "listingInfo", required = false)
    private ListingInfo listingInfo;
    @Element(name = "primaryCategory", required = false)
    private PrimaryCategory primaryCategory;
    @Element(name = "secondaryCategory", required = false)
    private SecondaryCategory secondaryCategory;
    @Element(name = "condition", required = false)
    private Condition condition;
    @Element(name = "location", required = false)
    private String location;
    @Element(name = "topRatedListing", required = false)
    private String topRatedListing;
    @Element(name = "globalId", required = false)
    private String globalId;
    @Element(name = "itemId", required = false)
    private String itemId;
    @Element(name = "shippingInfo", required = false)
    private ShippingInfo shippingInfo;
    @Element(name = "viewItemURL", required = false)
    private String viewItemURL;
    @Element(name = "productId", required = false)
    private ProductId productId;
    @Element(name = "country", required = false)
    private String country;
    @Element(name = "galleryURL", required = false)
    private String galleryURL;
    @Element(name = "galleryPlusPictureURL", required = false)
    private String galleryPlusPictureURL;
    @Element(name = "autoPay", required = false)
    private String autoPay;
    @Element(name = "title", required = false)
    private String title;
    @Element(name = "subtitle", required = false)
    private String subtitle;
    @Element(name = "postalCode", required = false)
    private String postalCode;
    @Element(name = "returnsAccepted", required = false)
    private String returnsAccepted;
    @Element(required = false)
    private SellingStatus sellingStatus;
    @Element(required = false)
    private DiscountPriceInfo discountPriceInfo;
    @Element(required = false)
    private String isMultiVariationListing;
    @Element(required = false)
    private String paymentMethod;
    @Element(required = false)
    private int charityId;

    public ListingInfo getListingInfo() {
        return listingInfo;
    }

    public void setListingInfo(ListingInfo listingInfo) {
        this.listingInfo = listingInfo;
    }

    public PrimaryCategory getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(PrimaryCategory primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public SecondaryCategory getSecondaryCategory() {
        return secondaryCategory;
    }

    public void setSecondaryCategory(SecondaryCategory secondaryCategory) {
        this.secondaryCategory = secondaryCategory;
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

    public String getTopRatedListing() {
        return topRatedListing;
    }

    public void setTopRatedListing(String topRatedListing) {
        this.topRatedListing = topRatedListing;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public String getViewItemURL() {
        return viewItemURL;
    }

    public void setViewItemURL(String viewItemURL) {
        this.viewItemURL = viewItemURL;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(String autoPay) {
        this.autoPay = autoPay;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getReturnsAccepted() {
        return returnsAccepted;
    }

    public void setReturnsAccepted(String returnsAccepted) {
        this.returnsAccepted = returnsAccepted;
    }

    public SellingStatus getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(SellingStatus sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public DiscountPriceInfo getDiscountPriceInfo() {
        return discountPriceInfo;
    }

    public void setDiscountPriceInfo(DiscountPriceInfo discountPriceInfo) {
        this.discountPriceInfo = discountPriceInfo;
    }

    public String getIsMultiVariationListing() {
        return isMultiVariationListing;
    }

    public void setIsMultiVariationListing(String isMultiVariationListing) {
        this.isMultiVariationListing = isMultiVariationListing;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }
}
