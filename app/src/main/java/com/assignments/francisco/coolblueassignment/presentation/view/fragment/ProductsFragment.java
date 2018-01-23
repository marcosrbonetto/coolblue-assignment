package com.assignments.francisco.coolblueassignment.presentation.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.di.components.CoolBlueComponentProvider;
import com.assignments.francisco.coolblueassignment.domain.model.Product;
import com.assignments.francisco.coolblueassignment.presentation.presenter.ProductsPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFragment extends Fragment {

    private List<Product> products;

    @BindView(R.id.search_button)
    Button searchButton;

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

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAllProducts();
            }
        });

        return parent;
    }
}
