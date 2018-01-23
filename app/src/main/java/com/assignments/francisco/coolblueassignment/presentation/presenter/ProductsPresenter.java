package com.assignments.francisco.coolblueassignment.presentation.presenter;

import com.assignments.francisco.coolblueassignment.domain.interactors.GetProducts;

import javax.inject.Inject;

/**
 * Created by fran on 22/01/18.
 */

public class ProductsPresenter {

    private GetProducts getProducts;

    @Inject
    public ProductsPresenter(GetProducts getProducts){
        this.getProducts = getProducts;
    }

    public void getAllProducts(){
        getProducts.execute();
    }

}
