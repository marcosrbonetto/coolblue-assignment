package com.assignments.francisco.coolblueassignment.domain.model;

import com.assignments.francisco.coolblueassignment.data.entity.Item;

/**
 * Created by fran on 21/01/18.
 */

public class Product {

    private final String title;
    private final String imageUrl;
    private final String price;

    public Product(Builder builder) {
        this.title = builder.title;
        this.imageUrl = builder.imageUrl;
        this.price = builder.price;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder {

        private static final String NO_TITLE = "The product has no title";
        private static final String PRICE_FORMAT = "%1$s %2$s";
        private String title = NO_TITLE;
        private String imageUrl;
        private String price;

        public Builder(Item item) {

            this.title = item.getTitle();

            this.imageUrl = item.getGalleryURL();

//            this.price = String.format(PRICE_FORMAT, item.getSellingStatus().getCurrentPrice().getCurrencyId(),
//                    item.getSellingStatus().getCurrentPrice().getContent());
        }

        public Product build() {
            return new Product(this);
        }
    }
}
