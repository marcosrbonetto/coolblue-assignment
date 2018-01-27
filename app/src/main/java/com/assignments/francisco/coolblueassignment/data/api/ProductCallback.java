package com.assignments.francisco.coolblueassignment.data.api;

import com.assignments.francisco.coolblueassignment.data.model.ProductsResponse;
import com.assignments.francisco.coolblueassignment.data.model.event.BaseResponseEvent;
import com.squareup.otto.Bus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Handler for HTTP response and performing events.
 *
 * @author Francisco Visintini
 */
public class ProductCallback implements Callback<ProductsResponse> {

    private BaseResponseEvent baseResponseEvent;
    private Bus bus;

    public ProductCallback(BaseResponseEvent baseResponseEvent, Bus bus) {
        this.baseResponseEvent = baseResponseEvent;
        this.bus = bus;
    }

    @Override
    public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
        baseResponseEvent.setResponse(response.body());
        baseResponseEvent.setCode(response.code());
        bus.post(baseResponseEvent);
    }

    @Override
    public void onFailure(Call<ProductsResponse> call, Throwable t) {
        baseResponseEvent.setThrowable(t);
        bus.post(baseResponseEvent);
    }
}
