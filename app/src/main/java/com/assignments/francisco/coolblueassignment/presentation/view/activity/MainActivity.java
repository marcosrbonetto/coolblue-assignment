package com.assignments.francisco.coolblueassignment.presentation.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.di.components.CoolBlueComponentProvider;
import com.assignments.francisco.coolblueassignment.presentation.view.fragment.ProductsFragment;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationHandler {

    @BindView(R.id.coolblue_toolbar)
    Toolbar coolblueToolbar;

    @Inject
    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CoolBlueComponentProvider) getApplicationContext()).getCoolBlueComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(coolblueToolbar);

        if (savedInstanceState == null) {
            navigateToAllProductsFragment();
        }
    }

    @Override
    public void navigateToAllProductsFragment() {
        addFragment(R.id.container, ProductsFragment.newInstance());
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.toolbar_filter) {
            bus.post(new FilterButtonPressedEvent());
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Used to trigger event when user press filter toolbar button
     */
    public class FilterButtonPressedEvent {
    }
}
