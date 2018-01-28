package com.assignments.francisco.coolblueassignment.domain;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByCategory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * GetProductsByCategory unit test class.
 *
 * @author Francisco Visintini
 */
public class GetProductsByCategoryTest {

    @Mock
    private FindingApiClientImpl findingApiClientImpl;

    GetProductsByCategory getProductsByCategory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        getProductsByCategory = new GetProductsByCategory(findingApiClientImpl);
    }

    @Test
    public void execute_shouldCallFindintApiClientGetProductsByCategory() {
        getProductsByCategory.execute();
        verify(findingApiClientImpl).getProductsByCategory();
    }
}
