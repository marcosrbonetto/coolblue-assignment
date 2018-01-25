package com.assignments.francisco.coolblueassignment.data.model.mapper;

import com.assignments.francisco.coolblueassignment.data.model.FindItemsByKeywordsResponse;
import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by fran on 22/01/18.
 */

public class ProductEntityDataMapper {

    public List<Product> transformProductEntities(FindItemsByKeywordsResponse result){
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
