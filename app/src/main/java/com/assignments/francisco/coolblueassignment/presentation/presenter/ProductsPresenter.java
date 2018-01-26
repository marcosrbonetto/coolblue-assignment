package com.assignments.francisco.coolblueassignment.presentation.presenter;

import com.assignments.francisco.coolblueassignment.data.model.event.GetProductsResponseEvent;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByCategory;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByKeywords;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

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

    @Inject
    public ProductsPresenter(Bus bus, GetProductsByCategory getProductsByCategory, GetProductsByKeywords getProductsByKeywords) {
        this.bus = bus;
        this.getProductsByCategory = getProductsByCategory;
        this.getProductsByKeywords = getProductsByKeywords;
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
    public void onGetProductsByCategoryEvent(GetProductsResponseEvent event) {
        if (view != null) {
            if (event.isSuccess()) {
                int productsCount = event.getResponse().size();
                if (productsCount == 0) {
                    view.showEmptyScreen();
                } else {
                    view.showProducts(event.getResponse());
                    if (event.isCategoryType()) {
                        view.setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
                    } else {
                        view.setShowingProductsLabelForSearch(productsCount);
                    }
                }
            } else {
                view.showErrorScreen();
            }
        }
    }

    public void getProductsByKeywords(String keywords, String minPrice, String maxPrice) {
        if (view != null) {
            if(keywords == null || keywords.isEmpty()){
                view.showEmptyKeywordsError();
                return;
            }

            if(hasFilters(minPrice, maxPrice)){
                if(areFiltersWellFormed(minPrice, maxPrice)){
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
     * @param minPrice
     * @param maxPrice
     * @return
     */
    private boolean hasFilters(String minPrice, String maxPrice) {
        //TODO This kind of method in a large application wouldn't be here.
        // Most probably filters would be in a different view with their
        // respective presenter
        return !minPrice.isEmpty() || !maxPrice.isEmpty();
    }

    /**
     * Validates filters are well formed.
     * @param minPrice
     * @param maxPrice
     * @return
     */
    private boolean areFiltersWellFormed(String minPrice, String maxPrice){
        //TODO This kind of method in a large application wouldn't be here.
        // Most probably filters would be in a different view with their
        // respective presenter
        try {
            double min = Double.parseDouble(minPrice);
            double max = Double.parseDouble(maxPrice);
            return  min <= max;
        } catch (NumberFormatException numberFormatException){
            return false;
        }
    }
}
