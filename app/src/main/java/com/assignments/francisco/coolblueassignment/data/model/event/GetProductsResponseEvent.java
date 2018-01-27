package com.assignments.francisco.coolblueassignment.data.model.event;


import com.assignments.francisco.coolblueassignment.data.model.Item;
import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;

import java.util.List;

/**
 * EventBus event to send for getProductsByCategory UC.
 */

public class GetProductsResponseEvent extends BaseResponseEvent<ProductsResponse> {

    public static final int CATEGORY_TYPE = 7;
    public static final int KEYWORDS_TYPE = 77;

    private int callType;

    public GetProductsResponseEvent(int callType) {
        this.callType = callType;
    }

    public boolean isCategoryType() {
        return callType == CATEGORY_TYPE;
    }
}
