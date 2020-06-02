package com.linus.cynix.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linus.cynix.R;
import com.linus.cynix.models.Shops;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopDetailFragment extends Fragment {
@BindView(R.id.shopImageView1)ImageView mShopImage;
@BindView(R.id.shopNameTextView)TextView mShopName;
@BindView(R.id.floorTextView)TextView mFloor;
@BindView(R.id.phoneTextView)TextView mPhone;
@BindView(R.id.buildingsTextView)TextView mBuilding;

private Shops mShop;

    public ShopDetailFragment() {
        // Required empty public constructor
    }

    public static ShopDetailFragment newInstance(Shops shops) {
        ShopDetailFragment shopDetailFragment = new ShopDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("shops", Parcels.wrap(shops));
        shopDetailFragment.setArguments(args);
        return shopDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShop = Parcels.unwrap(getArguments().getParcelable("shops"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mShop.getImage()).into(mShopImage);

        mShopName.setText(mShop.getName());
        mFloor.setText(mShop.getShopNumber());
        mPhone.setText(mShop.getPhone());
        mBuilding.setText(mShop.getBuildingName());

        return view;
    }
}