package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.FindItemsByKeywordsResponse;
import com.assignments.francisco.coolblueassignment.data.model.mapper.ProductEntityDataMapper;
import com.assignments.francisco.coolblueassignment.data.model.event.BaseResponseEvent;
import com.assignments.francisco.coolblueassignment.domain.model.Product;
import com.squareup.otto.Bus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handler for HTTP response and performing events.
 */
public final class ProductCallback implements Callback {

    private BaseResponseEvent baseResponseEvent;
    private Bus bus;
    private ProductEntityDataMapper productEntityDataMapper;

    public ProductCallback(BaseResponseEvent baseResponseEvent, Bus bus, ProductEntityDataMapper productEntityDataMapper) {
        this.baseResponseEvent = baseResponseEvent;
        this.bus = bus;
        this.productEntityDataMapper = productEntityDataMapper;
    }

    @Override
    public void onResponse(Call call, Response response) {
        List<Product> productList = productEntityDataMapper.transformProductEntities((FindItemsByKeywordsResponse) response.body());
        baseResponseEvent.setCode(response.code());
        baseResponseEvent.setResponse(productList);
        bus.post(baseResponseEvent);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        baseResponseEvent.setThrowable(t);
        bus.post(baseResponseEvent);
    }
}
