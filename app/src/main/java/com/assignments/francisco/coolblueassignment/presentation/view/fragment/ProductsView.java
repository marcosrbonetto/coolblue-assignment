package com.assignments.francisco.coolblueassignment.presentation.view.fragment;

import com.assignments.francisco.coolblueassignment.presentation.model.Product;

import java.util.List;

/**
 * Products fragment view.
 *
 * @author Francisco Visintini
 */
public interface ProductsView {

    void showProducts(List<Product> products);

    void showErrorScreen();

    void showLoadingScreen();

    void showEmptyScreen();

    void setShowingProductsLabelForSearch(int productsCount);

    void setShowingProductsLabelForCategory(String category);

    void showPriceFilterError();

    void showEmptyKeywordsError();
}
