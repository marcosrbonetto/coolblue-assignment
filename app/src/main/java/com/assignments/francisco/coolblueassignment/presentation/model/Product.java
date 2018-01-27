package com.assignments.francisco.coolblueassignment.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.assignments.francisco.coolblueassignment.data.model.Item;

import java.text.DecimalFormat;

/**
 * Created by fran on 27/01/18.
 */
public class Product implements Parcelable {

    private final String title;
    private final String imageUrl;
    private final String price;

    public Product(Product.Builder builder) {
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

            this.price = String.format(PRICE_FORMAT,
                    item.getSellingStatus().getCurrentPrice().getCurrencyId(),
                    getPriceWithoutTrailingZeros(item.getSellingStatus().getCurrentPrice().getPrice()));
        }

        /**
         * Removes trailing zeros.
         *
         * @return rounded price
         */
        private String getPriceWithoutTrailingZeros(String price) {
            String convertedPrice;
            try {
                DecimalFormat format = new DecimalFormat("0.00");
                convertedPrice = format.format(Double.parseDouble(price));
            } catch (NumberFormatException nfe) {
                convertedPrice = "Wrong price";
            }
            return convertedPrice;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(price);
    }

    protected Product(Parcel in) {
        title = in.readString();
        imageUrl = in.readString();
        price = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
