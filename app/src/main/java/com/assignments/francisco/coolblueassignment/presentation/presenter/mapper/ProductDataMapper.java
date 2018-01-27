package com.assignments.francisco.coolblueassignment.presentation.presenter.mapper;

import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 22/01/18.
 */
public class ProductDataMapper {

    /**
     * Receives a ProductsResponse and transforms it into a UI Product list.
     *
     * @param result products response from data layer.
     *
     * @return List of products
     *
     * @throws NullPointerException
     */
    public List<Product> transformProductEntities(ProductsResponse result) throws NullPointerException {
        List<Product> products = new ArrayList<>();
        List<Item> productEntities = result.getSearchResult().getProducts();

        if (productEntities != null && !productEntities.isEmpty()) {
            for (Item product : productEntities) {
                products.add(new Product.Builder(product).build());
            }
        }
        return products;
    }
}
