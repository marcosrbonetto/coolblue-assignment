package com.assignments.francisco.coolblueassignment.di.components;

import com.assignments.francisco.coolblueassignment.di.modules.CoolBlueModule;
import com.assignments.francisco.coolblueassignment.presentation.view.activity.MainActivity;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fran on 21/01/18.
 */

@Singleton
@Component(modules = CoolBlueModule.class)
public interface CoolBlueComponent {

    void inject(ProductsFragment fragment);

    void inject(MainActivity mainActivity);
}
