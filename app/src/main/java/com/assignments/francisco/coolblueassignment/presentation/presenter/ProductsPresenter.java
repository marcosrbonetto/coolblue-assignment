package com.assignments.francisco.coolblueassignment.presentation.presenter;

import android.support.annotation.NonNull;

import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByCategory;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsView;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */

public class ProductsPresenter {

    private GetProductsByCategory getProductsByCategory;
    private ProductsView view;

    @Inject
    public ProductsPresenter(GetProductsByCategory getProductsByCategory){
        this.getProductsByCategory = getProductsByCategory;
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
     * Get products according to default category.
     */
    public void getProductsByCategory(){
        getProductsByCategory.execute();
    }

}
