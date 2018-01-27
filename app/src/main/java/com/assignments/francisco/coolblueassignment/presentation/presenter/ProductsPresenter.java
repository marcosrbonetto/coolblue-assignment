package com.assignments.francisco.coolblueassignment.presentation.presenter;

import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByCategory;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByKeywords;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;
import com.assignments.francisco.coolblueassignment.presentation.presenter.mapper.ProductDataMapper;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */
public class ProductsPresenter {

    //TODO This shouldn't be like this. I should get all ebay categories and use them in the app.
    private static final String DEFAULT_CATEGORY = "Cellphones & Smartphones";

    private GetProductsByCategory getProductsByCategory;
    private GetProductsByKeywords getProductsByKeywords;
    private ProductsView view;
    private Bus bus;
    private ProductDataMapper productDataMapper;

    @Inject
    public ProductsPresenter(Bus bus, GetProductsByCategory getProductsByCategory, GetProductsByKeywords getProductsByKeywords,
            ProductDataMapper productDataMapper) {
        this.bus = bus;
        this.getProductsByCategory = getProductsByCategory;
        this.getProductsByKeywords = getProductsByKeywords;
        this.productDataMapper = productDataMapper;
    }

    /**
     * Set the view to interact with the presenter.
     *
     * @param view to interact with presenter.
     */
    public void setView(ProductsView view) {
        this.view = view;
    }

    /**
     * Register presenter in the bus
     */
    public void registerBus() {
        bus.register(this);
    }

    /**
     * Unregister presenter in the bus
     */
    public void unregisterBus() {
        bus.unregister(this);
    }

    /**
     * Get products according to default category.
     */
    public void getProductsByCategory() {
        view.showLoadingScreen();
        getProductsByCategory.execute();
    }

    @Subscribe
    public void onGetProductsEvent(GetProductsResponseEvent event) {
        if (view != null) {
            if (!event.isSuccess()) {
                view.showErrorScreen();
                return;
            }

            try {
                List<Product> productList = productDataMapper.transformProductEntities(event.getResponse());
                int productsCount = productList.size();
                if (productsCount == 0) {
                    view.showEmptyScreen();
                } else {
                    view.showProducts(productList);
                    if (event.isCategoryType()) {
                        view.setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
                    } else {
                        view.setShowingProductsLabelForSearch(productsCount);
                    }
                }
            } catch (NullPointerException npe) {
                view.showErrorScreen();
            }
        }
    }

    public void getProductsByKeywords(String keywords, String minPrice, String maxPrice) {
        if (view != null) {
            if (keywords == null || keywords.isEmpty()) {
                view.showEmptyKeywordsError();
                return;
            }

            if (hasFilters(minPrice, maxPrice)) {
                if (areFiltersWellFormed(minPrice, maxPrice)) {
                    view.showLoadingScreen();
                    getProductsByKeywords.execute(keywords, minPrice, maxPrice);
                } else {
                    view.showPriceFilterError();
                }
            } else {
                view.showLoadingScreen();
                getProductsByKeywords.execute(keywords);
            }
        }
    }

    /**
     * Validates if a request has price filter.
     *
     * @param minPrice
     * @param maxPrice
     *
     * @return
     */
    private boolean hasFilters(String minPrice, String maxPrice) {
        //TODO This kind of method in a large application wouldn't be here.
        // Most probably ui filters would be in a different view with their
        // respective presenter and models.
        return !minPrice.isEmpty() || !maxPrice.isEmpty();
    }

    /**
     * Validates filters are well formed.
     *
     * @param minPrice
     * @param maxPrice
     *
     * @return
     */
    private boolean areFiltersWellFormed(String minPrice, String maxPrice) {
        //TODO This kind of method in a large application wouldn't be here.
        // Most probably ui filters would be in a different view with their
        // respective presenter and models.
        try {
            double min = Double.parseDouble(minPrice);
            double max = Double.parseDouble(maxPrice);
            return min <= max;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
