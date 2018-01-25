package com.assignments.francisco.coolblueassignment.di.modules;

import android.content.Context;

import com.assignments.francisco.coolblueassignment.CoolBlueApplication;
import com.assignments.francisco.coolblueassignment.data.api.FindingApiClient;
import com.assignments.francisco.coolblueassignment.data.model.mapper.ProductDataMapper;
import com.squareup.otto.Bus;

import org.simpleframework.xml.core.Persister;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by fran on 21/01/18.
 */

@Singleton
@Module
public class CoolBlueModule {

    private CoolBlueApplication application;
    public static final String HOST = "http://svcs.ebay.com/";

    public CoolBlueModule(CoolBlueApplication application){
        this.application = application;
    }

    @Provides
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    Bus providesBus(){
        return new Bus();
    }

    @Singleton
    @Provides
    ProductDataMapper providesProductDataMapper(){
        return new ProductDataMapper();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(HOST)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(SimpleXmlConverterFactory.create(new Persister()))
                .build();
    }

    @Singleton
    @Provides
    FindingApiClient providesFindingApiClient(Retrofit retrofit) {
        return retrofit.create(FindingApiClient.class);
    }
}
