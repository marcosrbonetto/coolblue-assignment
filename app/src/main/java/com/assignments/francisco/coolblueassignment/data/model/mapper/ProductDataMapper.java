package com.assignments.francisco.coolblueassignment.data.model.mapper;

import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 22/01/18.
 */

public class ProductDataMapper {

    public List<Product> transformProductEntities(ProductsResponse result){
        ArrayList<Product> products = new ArrayList<>();
        List<Item> productEntities = result.getSearchResult().getProducts();

        if(productEntities != null && !productEntities.isEmpty()) {
            for (int i = 0; i < productEntities.size(); i++) {
                products.add(new Product.Builder(productEntities.get(i)).build());
            }
        }
        return products;
    }
}
