package com.assignments.francisco.coolblueassignment.presentation.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsFragment;

public class MainActivity extends AppCompatActivity implements NavigationHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToAllProductsFragment();
    }

    @Override
    public void navigateToAllProductsFragment() {
        addFragment(R.id.container, ProductsFragment.newInstance());
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.commit();
    }
}
