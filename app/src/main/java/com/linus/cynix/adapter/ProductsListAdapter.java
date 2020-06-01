package com.linus.cynix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.linus.cynix.R;
import com.linus.cynix.models.Shops;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.shopVieHolder> {
    private Context mContext;
    private List<Shops> mShops;

    public ProductsListAdapter(Context context,List<Shops>shops) {
        this.mContext= context;
        this.mShops=shops;
    }
    @Override
    public ProductsListAdapter.shopVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        shopVieHolder viewHolder = new shopVieHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ProductsListAdapter.shopVieHolder holder, int position) {
        holder.bindShop(mShops.get(position));
    }

    @Override
    public int getItemCount() {
        return mShops.size();
    }

    public class shopVieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.shopNameTextView)TextView mNameTextView;
        @BindView(R.id.buildingTextView) TextView mBuildingTextView;

        private Context mContext;


        public shopVieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }


        public void bindShop(Shops shops) {
            mNameTextView.setText(shops.getName());
            mBuildingTextView.setText(shops.getBuildingName());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
            Toast.makeText(mContext,"Cynix products",Toast.LENGTH_LONG).show();

//            mContext.startActivity(intent);
        }
    }
}
