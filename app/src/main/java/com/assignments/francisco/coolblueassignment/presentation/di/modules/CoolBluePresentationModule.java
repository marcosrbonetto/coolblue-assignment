package com.assignments.francisco.coolblueassignment.presentation.di.modules;

import android.content.Context;

import com.assignments.francisco.coolblueassignment.CoolBlueApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fran on 21/01/18.
 */
@Singleton
@Module
public class CoolBluePresentationModule {

    private CoolBlueApplication application;
    public static final String HOST = "http://svcs.ebay.com/";

    public CoolBluePresentationModule(CoolBlueApplication application) {
        this.application = application;
    }

    @Provides
    Context providesContext() {
        return application.getApplicationContext();
    }
}
