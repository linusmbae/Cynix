package com.linus.cynix.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.linus.cynix.ui.ProductsListActivity;
import com.linus.cynix.R;
import com.linus.cynix.models.Shops;
import com.linus.cynix.ui.ShopsDetails;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.shopVieHolder> {
    private Context mContext;
    private List<Shops> mShops;

    public ShopListAdapter(Context context, List<Shops>shops) {
        this.mContext= context;
        this.mShops=shops;
    }
    @Override
    public ShopListAdapter.shopVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item, parent, false);
        shopVieHolder viewHolder = new shopVieHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ShopListAdapter.shopVieHolder holder, int position) {
        holder.bindShop(mShops.get(position));
    }

    @Override
    public int getItemCount() {
        return mShops.size();
    }

    public class shopVieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.shopNameTextView)TextView mNameTextView;
        @BindView(R.id.buildingTextView) TextView mBuildingTextView;
        @BindView(R.id.shopImageView)ImageView mImageView;

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
            Picasso.get().load(shops.getImage()).into(mImageView);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ShopsDetails.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("shops", Parcels.wrap(mShops));
            Toast.makeText(mContext,"Cynix shops",Toast.LENGTH_LONG).show();

            mContext.startActivity(intent);
        }
    }
}
