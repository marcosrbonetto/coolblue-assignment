package com.assignments.francisco.coolblueassignment.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.presentation.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by fran on 22/01/18.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private List<Product> products;
    protected Context context;

    public ProductsAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(parent);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = products.get(position);

        holder.title.setText(product.getTitle());
        holder.price.setText(product.getPrice());
        setImageResourceWithPicasso(holder.image, product.getImageUrl());
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView price;
        private final TextView title;

        ProductViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false));
            image = itemView.findViewById(R.id.product_image);
            title = itemView.findViewById(R.id.product_title);
            price = itemView.findViewById(R.id.product_price);
        }
    }

    /**
     * Receives an imageView and a url, and sets the image retrieved by Glide. Assigns a default image if the url
     * is null or empty.
     *
     * @param imageView of resort.
     * @param url       to fetch the image from
     */
    private void setImageResourceWithPicasso(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context)
                   .load(url)
                   .placeholder(R.drawable.coolblue_loading)
                   .fit()
                   .centerCrop()
                   .into(imageView);
        } else {
            imageView.setImageResource(R.drawable.coolblue_no_image);
        }
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
