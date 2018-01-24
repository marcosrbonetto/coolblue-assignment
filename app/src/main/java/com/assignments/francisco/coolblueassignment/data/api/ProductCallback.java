package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.entity.FindItemsByKeywordsResponse;
import com.assignments.francisco.coolblueassignment.data.entity.mapper.ProductEntityDataMapper;
import com.assignments.francisco.coolblueassignment.data.event.BaseResponseEvent;
import com.assignments.francisco.coolblueassignment.domain.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handler for HTTP response and performing events.
 */
public final class ProductCallback implements Callback {

    private BaseResponseEvent baseResponseEvent;

    public ProductCallback(BaseResponseEvent baseResponseEvent) {
        this.baseResponseEvent = baseResponseEvent;
    }

    @Override
    public void onResponse(Call call, Response response) {
        List<Product> productList = ProductEntityDataMapper.transformProductEntities((FindItemsByKeywordsResponse) response.body());
        System.out.println("si");
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        System.out.println("no");
    }
}
