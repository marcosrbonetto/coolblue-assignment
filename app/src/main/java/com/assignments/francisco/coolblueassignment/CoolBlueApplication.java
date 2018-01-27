package com.assignments.francisco.coolblueassignment;

import android.app.Application;

import com.assignments.francisco.coolblueassignment.data.di.CoolBlueDataModule;
import com.assignments.francisco.coolblueassignment.presentation.di.components.CoolBlueComponent;
import com.assignments.francisco.coolblueassignment.presentation.di.components.CoolBlueComponentProvider;
import com.assignments.francisco.coolblueassignment.presentation.di.components.DaggerCoolBlueComponent;
import com.assignments.francisco.coolblueassignment.presentation.di.modules.CoolBluePresentationModule;

/**
 * Cool blue application.
 *
 * @author Francisco Visintini
 */
public class CoolBlueApplication extends Application implements CoolBlueComponentProvider {

    private static CoolBlueComponent coolBlueComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        coolBlueComponent = DaggerCoolBlueComponent.builder()
                                                   .coolBluePresentationModule(new CoolBluePresentationModule(this))
                                                   .coolBlueDataModule(new CoolBlueDataModule())
                                                   .build();

    }

    @Override
    public CoolBlueComponent getCoolBlueComponent() {
        return coolBlueComponent;
    }
}
