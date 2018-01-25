package com.assignments.francisco.coolblueassignment.data.model.event;


import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.List;

/**
 * EventBus event to send for getProductsByCategory UC.
 */

public class GetProductsResponseEvent extends BaseResponseEvent<List<Product>> {

}
