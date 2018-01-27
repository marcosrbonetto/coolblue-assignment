package com.assignments.francisco.coolblueassignment.data.model.event;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;

/**
 * EventBus event to send for getProductsByCategory UC.
 *
 * @author Francisco Visintini
 */
public class GetProductsResponseEvent extends BaseResponseEvent<ProductsResponse> {

    public static final int CATEGORY_TYPE = 7;
    public static final int KEYWORDS_TYPE = 77;

    private int callType;

    public GetProductsResponseEvent(int callType) {
        this.callType = callType;
    }

    /**
     * Validates if the event is for a category call.
     *
     * @return true if it is a category event, false otherwise.
     */
    public boolean isCategoryType() {
        return callType == CATEGORY_TYPE;
    }
}
