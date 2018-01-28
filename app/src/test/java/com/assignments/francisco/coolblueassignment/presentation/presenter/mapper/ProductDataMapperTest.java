package com.assignments.francisco.coolblueassignment.presentation.presenter.mapper;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;
import com.assignments.francisco.coolblueassignment.utils.Constant;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * ProductDataMapper unit test class.
 *
 * @author Francisco Visintini
 */
public class ProductDataMapperTest {

    private ProductDataMapper productDataMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productDataMapper = new ProductDataMapper();
    }

    @Test
    public void transformProductEntities_withProductEntitiesListWithTwoProducts_shouldTransformProductsCorrectly() {
        ProductsResponse productsResponse = Constant.getMockedProductsResponse();

        List<Product> productList = productDataMapper.transformProductEntities(productsResponse);

        Assert.assertTrue(productList.get(0) != null);
        Assert.assertTrue(productList.get(1) != null);
        Assert.assertTrue(productList.size() == 2);
    }
}
