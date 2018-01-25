package com.assignments.francisco.coolblueassignment.presentation.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.di.components.CoolBlueComponentProvider;
import com.assignments.francisco.coolblueassignment.domain.model.Product;
import com.assignments.francisco.coolblueassignment.presentation.presenter.ProductsPresenter;
import com.assignments.francisco.coolblueassignment.presentation.view.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFragment extends Fragment implements ProductsView {

    private static final String PRODUCTS = "products";
    private static final String SHOWING_ITEM_TEXT = "showingItemsText";
    private static final String SEARCH_BOX_TEXT = "searchBox";

    private ProductsAdapter productsAdapter;

    @BindView(R.id.search_button)
    Button searchButton;
    @BindView(R.id.search_box)
    EditText searchBox;
    @BindView(R.id.showing_items_label)
    TextView showingItemsLabel;
    @BindView(R.id.products_recycler)
    RecyclerView productsRecycler;
    @BindView(R.id.loading_view)
    View loadingView;
    @BindView(R.id.error_view)
    View errorView;
    @BindView(R.id.error_label)
    TextView errorLabel;
    @BindView(R.id.info_view)
    View infoView;

    @Inject
    protected ProductsPresenter presenter;

    public ProductsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProductsFragment.
     */
    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CoolBlueComponentProvider) getContext().getApplicationContext()).getCoolBlueComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this, parent);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        productsRecycler.setLayoutManager(layoutManager);
        productsRecycler.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));

        setupClickInSearchButton();
        return parent;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (productsAdapter != null) {
            outState.putParcelableArrayList(PRODUCTS, (ArrayList) productsAdapter.getProducts());
            outState.putString(SEARCH_BOX_TEXT, searchBox.getText().toString());
            outState.putString(SHOWING_ITEM_TEXT, showingItemsLabel.getText().toString());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if(savedInstanceState != null && savedInstanceState.containsKey(PRODUCTS)) {
            ArrayList<Product> products = savedInstanceState.getParcelableArrayList(PRODUCTS);
            showProducts(products);
            searchBox.setText(savedInstanceState.getString(SEARCH_BOX_TEXT));
            showingItemsLabel.setText(savedInstanceState.getString(SHOWING_ITEM_TEXT));
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        presenter.setView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        presenter.registerBus();
        if (productsAdapter == null) {
            presenter.getProductsByCategory();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        presenter.unregisterBus();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        presenter.setView(null);
        super.onDestroyView();
    }

    @Override
    public void showProducts(List<Product> products) {
        changeSearchBoxState(true);
        productsRecycler.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);

        setAdapterRecycler(products);
    }

    @Override
    public void showErrorScreen() {
        productsRecycler.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);
    }

    @Override
    public void showLoadingScreen() {
        productsRecycler.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
        infoView.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyScreen() {
        productsRecycler.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);

        showingItemsLabel.setText(R.string.showing_items_label_no_results);
    }

    @Override
    public void setShowingProductsLabelForSearch(int productsCount) {
        showingItemsLabel.setText(getString(R.string.showing_items_label, productsCount, searchBox.getText()));
    }

    @Override
    public void setShowingProductsLabelForCategory(String category) {
        showingItemsLabel.setText(getString(R.string.showing_items_label_category, category));
    }

    private void setupClickInSearchButton() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSearchBoxState(false);
                presenter.getProductsByKeywords(searchBox.getText().toString());
            }
        });
    }

    private void changeSearchBoxState(boolean enabled) {
        searchBox.setEnabled(enabled);
        searchButton.setEnabled(enabled);
    }

    private void setAdapterRecycler(List<Product> products) {
        productsAdapter = new ProductsAdapter(products, getContext());
        productsRecycler.setAdapter(productsAdapter);
    }
}
