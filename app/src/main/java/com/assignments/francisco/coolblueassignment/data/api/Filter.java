package com.assignments.francisco.coolblueassignment.data.api;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by fran on 22/01/18.
 */

public class Filter {

    @Retention(SOURCE)
    @StringDef({
            FilterName.MIN_PRICE,
            FilterName.MAX_PRICE,
            FilterName.COLOR
    })
    @interface FilterName{
        String MIN_PRICE = "minPrice";
        String MAX_PRICE = "maxPrice";
        String COLOR = "color";
    }

    private @FilterName
    String name;
    private String value;

    public Filter(@FilterName String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
