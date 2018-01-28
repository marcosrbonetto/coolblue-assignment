package com.assignments.francisco.coolblueassignment.presentation.presenter;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByCategory;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByKeywords;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;
import com.assignments.francisco.coolblueassignment.presentation.presenter.mapper.ProductDataMapper;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsView;
import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.assignments.francisco.coolblueassignment.presentation.presenter.ProductsPresenter.DEFAULT_CATEGORY;
import static com.assignments.francisco.coolblueassignment.utils.Constant.EMPTY_KEYWORDS;
import static com.assignments.francisco.coolblueassignment.utils.Constant.KEYWORDS;
import static com.assignments.francisco.coolblueassignment.utils.Constant.MAX_PRICE_FILTER;
import static com.assignments.francisco.coolblueassignment.utils.Constant.MAX_PRICE_FILTER_MALFORMED;
import static com.assignments.francisco.coolblueassignment.utils.Constant.MIN_PRICE_FILTER;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * ProductsPresenter unit test class.
 *
 * @author Francisco Visintini
 */
public class ProductsPresenterTest {

    @Mock
    private GetProductsByCategory getProductsByCategory;

    @Mock
    private GetProductsByKeywords getProductsByKeywords;

    @Mock
    private ProductsView view;

    @Mock
    private Bus bus;

    @Mock
    private ProductDataMapper productDataMapper;

    private ProductsPresenter productsPresenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productsPresenter = new ProductsPresenter(bus, getProductsByCategory, getProductsByKeywords, productDataMapper);
        productsPresenter.setView(view);
    }

    @Test
    public void unregisterBus_shouldCallUnregister() {
        productsPresenter.unregisterBus();
        verify(bus).unregister(productsPresenter);
    }

    @Test
    public void registerBus_shouldCallUnregister() {
        productsPresenter.registerBus();
        verify(bus).register(productsPresenter);
    }


    @Test
    public void getProductsByCategory_shouldCallLoadingViewInUIAndCallGetProductsByCategoryInteractorExecute() {
        productsPresenter.getProductsByCategory();
        verify(view).showLoadingScreen();
        verify(getProductsByCategory).execute();
    }

    @Test
    public void getProductsByCategory_shouldDoNothingWhenViewIsNull() {
        productsPresenter.setView(null);
        productsPresenter.getProductsByCategory();
        verifyZeroInteractions(view);
        verifyZeroInteractions(getProductsByCategory);
    }

    @Test
    public void onGetProductsEvent_viewIsNull_shouldDoNothing() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        productsPresenter.setView(null);
        productsPresenter.onGetProductsEvent(event);

        verify(productDataMapper, never()).transformProductEntities(any(ProductsResponse.class));
        verify(view, never()).showErrorScreen();
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).showEmptyScreen();
        verify(view, never()).setShowingProductsLabelForSearch(anyInt());
        verify(view, never()).setShowingProductsLabelForCategory(anyString());
        verify(view, never()).showProducts(any(List.class));
    }

    @Test
    public void onGetProductsEvent_eventIsNotSuccess_shouldShowErrorScreen() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        when(event.isSuccess()).thenReturn(false);

        productsPresenter.onGetProductsEvent(event);

        verify(view).showErrorScreen();
        verify(productDataMapper, never()).transformProductEntities(any(ProductsResponse.class));
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).showEmptyScreen();
        verify(view, never()).setShowingProductsLabelForSearch(anyInt());
        verify(view, never()).setShowingProductsLabelForCategory(anyString());
        verify(view, never()).showProducts(any(List.class));
    }

    @Test
    public void onGetProductsEvent_productWithEmptyItems_shouldShowEmptyScreen() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        ProductsResponse productsResponse = mock(ProductsResponse.class);
        List<Product> products = new ArrayList<>();
        when(event.isSuccess()).thenReturn(true);
        when(event.isCategoryType()).thenReturn(false);
        when(event.getResponse()).thenReturn(productsResponse);
        when(productDataMapper.transformProductEntities(event.getResponse())).thenReturn(products);


        productsPresenter.onGetProductsEvent(event);

        verify(productDataMapper).transformProductEntities(any(ProductsResponse.class));
        verify(view).showEmptyScreen();
        verify(view, never()).showProducts(products);
        verify(view, never()).showErrorScreen();
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).setShowingProductsLabelForSearch(anyInt());
        verify(view, never()).setShowingProductsLabelForCategory(anyString());
    }

    @Test
    public void onGetProductsEvent_productWithItemsAndKeywordsCategoryType_shouldShowProductsScreenAndSetShowingProductsLabelForSearch() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        ProductsResponse productsResponse = mock(ProductsResponse.class);
        List<Product> products = getCompleteMockedProducts();
        when(event.isSuccess()).thenReturn(true);
        when(event.isCategoryType()).thenReturn(false);
        when(event.getResponse()).thenReturn(productsResponse);
        when(productDataMapper.transformProductEntities(event.getResponse())).thenReturn(products);

        productsPresenter.onGetProductsEvent(event);

        verify(productDataMapper).transformProductEntities(any(ProductsResponse.class));
        verify(view).setShowingProductsLabelForSearch(anyInt());
        verify(view).showProducts(products);
        verify(view, never()).showErrorScreen();
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).showEmptyScreen();
        verify(view, never()).setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
    }

    @Test
    public void onGetProductsEvent_productWithItemsAndCategoryCategoryType_shouldShowProductsScreenAndSetShowingProductsLabelForCategory() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        ProductsResponse productsResponse = mock(ProductsResponse.class);
        List<Product> products = getCompleteMockedProducts();
        when(event.isSuccess()).thenReturn(true);
        when(event.isCategoryType()).thenReturn(true);
        when(event.getResponse()).thenReturn(productsResponse);
        when(productDataMapper.transformProductEntities(event.getResponse())).thenReturn(products);

        productsPresenter.onGetProductsEvent(event);

        verify(productDataMapper).transformProductEntities(any(ProductsResponse.class));
        verify(view).setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
        verify(view).showProducts(products);
        verify(view, never()).showErrorScreen();
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).showEmptyScreen();
        verify(view, never()).setShowingProductsLabelForSearch(anyInt());
    }

    @Test
    public void onGetProductsEvent_withNullPointerException_shouldShowErrorScreen() {
        GetProductsResponseEvent event = mock(GetProductsResponseEvent.class);
        when(event.isSuccess()).thenReturn(true);
        when(event.getResponse()).thenReturn(null);
        when(productDataMapper.transformProductEntities(event.getResponse())).thenThrow(NullPointerException.class);

        productsPresenter.onGetProductsEvent(event);

        verify(view).showErrorScreen();
        verify(productDataMapper).transformProductEntities(event.getResponse());
        verify(view, never()).setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
        verify(view, never()).showProducts(any(List.class));
        verify(view, never()).showPriceFilterError();
        verify(view, never()).showEmptyKeywordsError();
        verify(view, never()).showLoadingScreen();
        verify(view, never()).showEmptyScreen();
        verify(view, never()).setShowingProductsLabelForSearch(anyInt());
    }

    @Test
    public void getProductsByKeywords_withNullView_shouldDoNothing() {
        productsPresenter.setView(null);
        productsPresenter.getProductsByKeywords("", "", "");
        verifyZeroInteractions(view);
        verifyZeroInteractions(getProductsByKeywords);
    }

    @Test
    public void getProductsByKeywords_withNullKeywords_shouldShowEmptyKeywordsError() {
        productsPresenter.getProductsByKeywords(null, "", "");
        verify(view).showEmptyKeywordsError();
        verifyZeroInteractions(getProductsByKeywords);
    }

    @Test
    public void getProductsByKeywords_withEmptyKeywords_shouldShowEmptyKeywordsError() {
        productsPresenter.getProductsByKeywords(EMPTY_KEYWORDS, "", "");
        verify(view).showEmptyKeywordsError();
        verifyZeroInteractions(getProductsByKeywords);
    }

    @Test
    public void getProductsByKeywords_withKeywordsAndEmptyFilters_shouldShowLoadingScreenAndExecuteGetProductsByKeywordsInteractor() {
        productsPresenter.getProductsByKeywords(KEYWORDS, "", "");
        verify(view).showLoadingScreen();
        verify(getProductsByKeywords).execute(KEYWORDS);
    }

    @Test
    public void getProductsByKeywords_withKeywordsAndWellFormedFilters_shouldShowLoadingScreenAndExecuteGetProductsByKeywordsInteractorWithFilters() {
        productsPresenter.getProductsByKeywords(KEYWORDS, MIN_PRICE_FILTER, MAX_PRICE_FILTER);
        verify(view).showLoadingScreen();
        verify(getProductsByKeywords).execute(KEYWORDS, MIN_PRICE_FILTER, MAX_PRICE_FILTER);
    }

    @Test
    public void getProductsByKeywords_withKeywordsAndMalformedFilters_shouldShowPriceFilterError() {
        productsPresenter.getProductsByKeywords(KEYWORDS, MIN_PRICE_FILTER, MAX_PRICE_FILTER_MALFORMED);
        verify(view).showPriceFilterError();
        verifyZeroInteractions(getProductsByKeywords);
    }

    private List<Product> getCompleteMockedProducts() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        return products;
    }
}
