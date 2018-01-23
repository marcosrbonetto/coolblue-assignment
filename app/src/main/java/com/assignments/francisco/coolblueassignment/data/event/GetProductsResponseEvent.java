package com.assignments.francisco.coolblueassignment.data.event;


import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.List;

/**
 * EventBus event to send for getAllProducts UC.
 */

public class GetProductsResponseEvent extends BaseResponseEvent<List<Product>> {

}
