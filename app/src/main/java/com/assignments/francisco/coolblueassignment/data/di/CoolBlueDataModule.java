package com.assignments.francisco.coolblueassignment.data.di;

import android.content.Context;

import com.assignments.francisco.coolblueassignment.data.api.FindingApiClient;
import com.assignments.francisco.coolblueassignment.presentation.presenter.mapper.ProductDataMapper;
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
 * Created by f.visintini on 26/01/18.
 */
@Singleton
@Module
public class CoolBlueDataModule {

    public static final String HOST = "http://svcs.ebay.com/";

    @Singleton
    @Provides
    Bus providesBus() {
        return new Bus();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(7, TimeUnit.SECONDS);

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
