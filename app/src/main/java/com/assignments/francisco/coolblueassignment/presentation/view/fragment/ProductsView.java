package com.assignments.francisco.coolblueassignment.presentation.view.fragment;

import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.List;

/**
 * Created by fran on 24/01/18.
 */

public interface ProductsView {

    void showProducts(List<Product> products);

    void showErrorScreen(String error);

    void showEmptyScreen();

    void setShowingItemsLabel(String showingItemsText);

    void changeSearchButtonState(boolean enabled);
}
