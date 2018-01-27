package com.assignments.francisco.coolblueassignment.presentation.di.modules;

import android.content.Context;

import com.assignments.francisco.coolblueassignment.CoolBlueApplication;
import com.assignments.francisco.coolblueassignment.presentation.presenter.mapper.ProductDataMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Presentation layer DI module.
 *
 * @author Francisco Visintini
 */
@Singleton
@Module
public class CoolBluePresentationModule {

    private CoolBlueApplication application;

    public CoolBluePresentationModule(CoolBlueApplication application) {
        this.application = application;
    }

    @Provides
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    ProductDataMapper providesProductDataMapper() {
        return new ProductDataMapper();
    }
}
