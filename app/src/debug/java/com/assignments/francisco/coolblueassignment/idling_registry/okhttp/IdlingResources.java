package com.assignments.francisco.coolblueassignment.idling_registry.okhttp;

import android.support.test.espresso.IdlingRegistry;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import okhttp3.OkHttpClient;

/**
 * Debug class in charge of adding Idling Resource for HttpClient calls.
 *
 * @author Francisco Visintini
 */
public abstract class IdlingResources {
    public static void registerOkHttp(OkHttpClient client) {
        IdlingRegistry.getInstance().register(OkHttp3IdlingResource.create(
                "okhttp", client));
    }
}
