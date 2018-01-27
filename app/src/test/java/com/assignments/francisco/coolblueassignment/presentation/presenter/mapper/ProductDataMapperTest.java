package com.assignments.francisco.coolblueassignment.presentation.presenter.mapper;

import com.assignments.francisco.coolblueassignment.data.model.CurrentPrice;
import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.data.model.SearchResult;
import com.assignments.francisco.coolblueassignment.data.model.SellingStatus;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ProductDataMapper unit test class.
 *
 * @author Francisco Visintini
 */
public class ProductDataMapperTest {

    private static final String USD_CURRENCY = "USD";
    private static final String MOCKED_PRICE = "10.0";
    private static final String TITLE = "mocked title";
    private static final String GALLERY_URL = "mocked gallery";

    private ProductDataMapper productDataMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productDataMapper = new ProductDataMapper();
    }

    @Test
    public void transformProductEntities_withProductEntitiesListWithTwoProducts_shouldTransformProductsCorrectly() {
        ArrayList<Item> items = getProductResponseItems();

        ProductsResponse productsResponse = mock(ProductsResponse.class);
        SearchResult searchResult = mock(SearchResult.class);
        when(productsResponse.getSearchResult()).thenReturn(searchResult);
        when(searchResult.getProducts()).thenReturn(items);

        List<Product> productList = productDataMapper.transformProductEntities(productsResponse);

        Assert.assertTrue(productList.get(0) != null);
        Assert.assertTrue(productList.get(1) != null);
        Assert.assertTrue(productList.size() == 2);
    }

    private ArrayList<Item> getProductResponseItems() {
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

        return items;
    }
}
