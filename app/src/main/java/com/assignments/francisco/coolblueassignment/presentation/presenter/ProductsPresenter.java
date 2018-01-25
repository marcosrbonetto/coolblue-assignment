package com.assignments.francisco.coolblueassignment.presentation.presenter;

import android.support.annotation.NonNull;

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
    public void setView(@NonNull ProductsView view) {
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
                if (event.getResponse().size() == 0) {
                    view.showEmptyScreen();
                } else {
                    view.showProducts(event.getResponse());
                    view.setShowingProductsLabelForCategory(DEFAULT_CATEGORY);
                }
            } else {
                view.showErrorScreen();
            }
        }
    }

    public void getProductsByKeywords(String keywords) {
        view.showLoadingScreen();
        getProductsByKeywords.execute(keywords);
    }
}
