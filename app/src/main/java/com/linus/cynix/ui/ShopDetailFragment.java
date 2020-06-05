package com.linus.cynix.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.linus.cynix.Constants;
import com.linus.cynix.R;
import com.linus.cynix.models.Shops;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopDetailFragment extends Fragment implements View.OnClickListener {
@BindView(R.id.shopImageView1)ImageView mShopImage;
@BindView(R.id.shopNameTextView)TextView mShopName;
@BindView(R.id.floorTextView)TextView mFloor;
@BindView(R.id.phoneTextView)TextView mPhone;
@BindView(R.id.buildingsTextView)TextView mBuilding;
@BindView(R.id.emailTextView)TextView mEmail;
@BindView(R.id.saveButton)Button mSave;

private SharedPreferences.Editor mEditor;

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
        mEmail.setText(mShop.getEmail());
        mPhone.setOnClickListener(this);
        mEmail.setOnClickListener(this);
        mSave.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v){
        if (v==mPhone){
            Intent phoneIntent =new Intent(Intent.ACTION_DIAL,
            Uri.parse("tel:" + mShop.getPhone()));
            startActivity(phoneIntent);
        }
        if (v==mEmail){
            Intent emailIntent=new Intent(Intent.ACTION_SENDTO,
                    Uri.parse("MAILTO:"+mShop.getEmail()));
            startActivity(emailIntent);
        }
        if (v == mSave) {
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_SHOPS);
            restaurantRef.push().setValue(mShop);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}