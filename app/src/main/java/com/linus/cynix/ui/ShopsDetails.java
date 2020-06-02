package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.linus.cynix.R;
import com.linus.cynix.adapter.ShopPageAdapter;
import com.linus.cynix.models.Shops;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopsDetails extends AppCompatActivity {
    @BindView(R.id.viewPager)ViewPager mViewPager;
    private ShopPageAdapter adapterViewPager;
    List<Shops>mShops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops_details);
        ButterKnife.bind(this);

        mShops = Parcels.unwrap(getIntent().getParcelableExtra("shops"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ShopPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mShops);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}