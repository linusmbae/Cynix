package com.linus.cynix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductListsAdapter extends BaseAdapter {
private String[] mMenWear;
private Context mContext;

    public ProductListsAdapter(String[] menWear,Context context) {
        this.mMenWear = menWear;
        this.mContext= context;
    }

    @Override
    public int getCount() {
        return mMenWear.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView==null)
        {
            gridView=layoutInflater.inflate(R.layout.products_grid_view1,null);
            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_picture);
            letterView.setText(mMenWear[position]);
        }else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
