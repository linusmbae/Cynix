package com.linus.cynix.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.linus.cynix.models.Shops;
import com.linus.cynix.ui.ShopDetailFragment;

import java.util.List;

public class ShopPageAdapter extends FragmentPagerAdapter {
    private List<Shops>mShops;

    public ShopPageAdapter(FragmentManager fm, int behavior, List<Shops> shops) {
        super(fm, behavior);
        mShops = shops;
    }

    @Override
    public Fragment getItem(int position) {
        return ShopDetailFragment.newInstance(mShops.get(position));
    }

    @Override
    public int getCount() {
        return mShops.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mShops.get(position).getName();
    }
}
