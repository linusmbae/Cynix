package com.linus.cynix.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.linus.cynix.R;
import com.linus.cynix.models.Products;
import com.linus.cynix.models.Shops;
import com.linus.cynix.ui.ShopsDetails;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListsAdapter extends RecyclerView.Adapter<ProductListsAdapter.productVieHolder> {
private Context mContext;

private List<Products> mProducts;


    public ProductListsAdapter(Context context,List<Products> products) {
        this.mContext= context;
        this.mProducts=products;
    }

    @Override
    public ProductListsAdapter.productVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_grid_view_row, parent, false);
        ProductListsAdapter.productVieHolder viewHolder = new ProductListsAdapter.productVieHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductListsAdapter.productVieHolder holder, int position) {
        holder.bindProduct(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class productVieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.productName)TextView mNameTextView;
        @BindView(R.id.imageView)ImageView mImageView;

        private Context mContext;


        public productVieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindProduct(Products products) {
            mNameTextView.setText(products.getName());
            Picasso.get().load(products.getImage()).into(mImageView);
        }

        @Override
        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, ShopsDetails.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("shops", Parcels.wrap(mShops));
//            Toast.makeText(mContext,"Cynix shops",Toast.LENGTH_LONG).show();
//
//            mContext.startActivity(intent);
        }
    }
}
