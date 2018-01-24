package com.assignments.francisco.coolblueassignment.presentation.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFragment extends Fragment implements ProductsView{

    private List<Product> products;
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

        setupClickInSearchButton();

        return parent;
    }

    @Override
    public void showProducts(List<Product> products) {
        productsRecycler.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);

        this.products = products;
        productsAdapter = new ProductsAdapter(products, getContext());
        productsRecycler.setAdapter(productsAdapter);
    }

    @Override
    public void showErrorScreen(String error) {
        productsRecycler.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);
        errorLabel.setText(error);
    }

    @Override
    public void showEmptyScreen() {
        productsRecycler.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        infoView.setVisibility(View.GONE);
    }

    @Override
    public void setShowingItemsLabel(String showingItemsText) {
        showingItemsLabel.setText(showingItemsText);
    }

    private void setupClickInSearchButton() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getProductsByCategory();
            }
        });
    }

    @Override
    public void changeSearchButtonState(boolean enabled){
        searchButton.setEnabled(enabled);
    }
}
