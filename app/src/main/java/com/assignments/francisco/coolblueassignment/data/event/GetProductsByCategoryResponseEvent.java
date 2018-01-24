package com.assignments.francisco.coolblueassignment.data.event;


import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.List;

/**
 * EventBus event to send for getProductsByCategory UC.
 */

public class GetProductsByCategoryResponseEvent extends BaseResponseEvent<List<Product>> {

}
