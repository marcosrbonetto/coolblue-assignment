package com.assignments.francisco.coolblueassignment.utils;

/**
 * Copy utils class.
 *
 * @author Francisco Visintini
 */
public class Copy {

    public static final String DEFAULT_SHOWING_ITEMS_LABEL = "Showing products for Cellphones & Smartphones category";
    private static final String SHOWING_ITEMS_LABEL = "Showing %1$d items for %2$s";
    public static final String MOCKED_SEARCH_TEXT = "Nexus 5x";
    public static final String MOCKED_MIN_PRICE_FILTER = "10.10";
    public static final String MOCKED_MAX_PRICE_FILTER = "100.89";

    public static String getShowingItemsLabel(int itemsCount, String keyWords) {
        return String.format(SHOWING_ITEMS_LABEL, itemsCount, keyWords);
    }
}
