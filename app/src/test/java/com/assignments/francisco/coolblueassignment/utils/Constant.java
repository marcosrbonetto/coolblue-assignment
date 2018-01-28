package com.assignments.francisco.coolblueassignment.utils;

import com.assignments.francisco.coolblueassignment.data.model.CurrentPrice;
import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.data.model.SearchResult;
import com.assignments.francisco.coolblueassignment.data.model.SellingStatus;

import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by fran on 27/01/18.
 */

public class Constant {
    public static final String EMPTY_KEYWORDS = "";
    public static final String KEYWORDS = "Valid keywords";
    public static final String MAX_PRICE_FILTER = "10.10";
    public static final String MAX_PRICE_FILTER_MALFORMED = "MALFORMED";
    public static final String MIN_PRICE_FILTER = "1.10";

    public static final String USD_CURRENCY = "USD";
    public static final String MOCKED_PRICE = "10.0";
    public static final String TITLE = "mocked title";
    public static final String GALLERY_URL = "mocked gallery";

    public static ProductsResponse getMockedProductsResponse() {
        //ITEM 1
        Item mockItem = mock(Item.class);
        SellingStatus sellingStatus = mock(SellingStatus.class);
        CurrentPrice currentPrice = mock(CurrentPrice.class);
        Mockito.when(mockItem.getTitle()).thenReturn(TITLE);
        Mockito.when(mockItem.getGalleryURL()).thenReturn(GALLERY_URL);
        Mockito.when(currentPrice.getCurrencyId()).thenReturn(USD_CURRENCY);
        Mockito.when(currentPrice.getPrice()).thenReturn(MOCKED_PRICE);
        Mockito.when(sellingStatus.getCurrentPrice()).thenReturn(currentPrice);
        Mockito.when(mockItem.getSellingStatus()).thenReturn(sellingStatus);

        //ITEM 2
        Item mockItem2 = mock(Item.class);
        SellingStatus sellingStatus2 = mock(SellingStatus.class);
        CurrentPrice currentPrice2 = mock(CurrentPrice.class);
        Mockito.when(mockItem2.getTitle()).thenReturn(TITLE);
        Mockito.when(mockItem2.getGalleryURL()).thenReturn(GALLERY_URL);
        Mockito.when(currentPrice2.getCurrencyId()).thenReturn(USD_CURRENCY);
        Mockito.when(currentPrice2.getPrice()).thenReturn(MOCKED_PRICE);
        Mockito.when(sellingStatus2.getCurrentPrice()).thenReturn(currentPrice2);
        Mockito.when(mockItem2.getSellingStatus()).thenReturn(sellingStatus2);

        ArrayList<Item> items = new ArrayList<>();
        items.add(mockItem);
        items.add(mockItem2);

        ProductsResponse productsResponse = mock(ProductsResponse.class);
        SearchResult searchResult = mock(SearchResult.class);
        when(productsResponse.getSearchResult()).thenReturn(searchResult);
        when(searchResult.getProducts()).thenReturn(items);

        return productsResponse;
    }
}
