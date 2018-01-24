package com.assignments.francisco.coolblueassignment.data.api;

/**
 * Created by fran on 24/01/18.
 */

public abstract class FindingApi extends EbayApi {

    public static final String VERSION = "1.13.0";
    public static final int DEFAULT_PRODUCTS_CATEGORY = 9355;//Cell Phones & Smartphones category.
    public static final String FIND_PRODUCTS_BY_CATEGORY_OPERATION_NAME = "findItemsByCategory";
    public static final String FIND_PRODUCTS_BY_KEYWORDS_OPERATION_NAME = "findItemsByKeywords";
}
