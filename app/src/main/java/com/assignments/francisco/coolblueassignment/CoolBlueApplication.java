package com.assignments.francisco.coolblueassignment;

import android.app.Application;

import com.assignments.francisco.coolblueassignment.di.components.CoolBlueComponent;
import com.assignments.francisco.coolblueassignment.di.components.CoolBlueComponentProvider;
import com.assignments.francisco.coolblueassignment.di.components.DaggerCoolBlueComponent;
import com.assignments.francisco.coolblueassignment.di.modules.CoolBlueModule;

/**
 * Created by fran on 21/01/18.
 */
public class CoolBlueApplication extends Application implements CoolBlueComponentProvider {

    private static CoolBlueComponent coolBlueComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        coolBlueComponent = DaggerCoolBlueComponent.builder()
                                                   .coolBlueModule(new CoolBlueModule(this))
                                                   .build();

    }

    @Override
    public CoolBlueComponent getCoolBlueComponent() {
        return coolBlueComponent;
    }
}
