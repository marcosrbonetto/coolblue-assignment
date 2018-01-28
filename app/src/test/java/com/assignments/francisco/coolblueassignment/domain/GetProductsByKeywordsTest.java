package com.assignments.francisco.coolblueassignment.domain;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClientImpl;
import com.assignments.francisco.coolblueassignment.domain.interactors.GetProductsByKeywords;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.assignments.francisco.coolblueassignment.utils.Constant.KEYWORDS;
import static com.assignments.francisco.coolblueassignment.utils.Constant.MAX_PRICE_FILTER;
import static com.assignments.francisco.coolblueassignment.utils.Constant.MIN_PRICE_FILTER;
import static org.mockito.Mockito.verify;

/**
 * GetProductsByKeywords unit test class.
 *
 * @author Francisco Visintini
 */
public class GetProductsByKeywordsTest {

    @Mock
    private FindingApiClientImpl findingApiClientImpl;

    GetProductsByKeywords getProductsByKeywords;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        getProductsByKeywords = new GetProductsByKeywords(findingApiClientImpl);
    }

    @Test
    public void execute_shouldCallFindintApiClientGetProductsByKeywordsWithOneParameter() {
        getProductsByKeywords.execute(KEYWORDS);
        verify(findingApiClientImpl).getProductsByKeywords(KEYWORDS);
    }

    @Test
    public void execute_shouldCallFindintApiClientGetProductsByKeywordsWithFilters() {
        getProductsByKeywords.execute(KEYWORDS, MIN_PRICE_FILTER, MAX_PRICE_FILTER);
        verify(findingApiClientImpl).getProductsByKeywords(KEYWORDS, MIN_PRICE_FILTER, MAX_PRICE_FILTER);
    }
}
