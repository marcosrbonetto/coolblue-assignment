package com.assignments.francisco.coolblueassignment.data.entity.mapper;

import com.assignments.francisco.coolblueassignment.data.entity.FindItemsByKeywordsResponse;
import com.assignments.francisco.coolblueassignment.data.entity.Item;
import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 22/01/18.
 */

public class ProductEntityDataMapper {

    public static List<Product> transformProductEntities(FindItemsByKeywordsResponse result){
        ArrayList<Product> products = new ArrayList<>();

        if(!result.searchResult.item.isEmpty()) {
            List<Item> productEntities = result.searchResult.item;

            for (int i = 0; i < productEntities.size(); i++) {
                products.add(new Product.Builder(productEntities.get(i)).build());
            }
        }
        return products;
    }

}
