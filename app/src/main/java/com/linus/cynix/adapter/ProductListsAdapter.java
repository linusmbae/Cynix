package com.linus.cynix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.linus.cynix.R;

public class ProductListsAdapter extends BaseAdapter {
private String[] mMenWear;
private Context mContext;
private int[] mImages;


    public ProductListsAdapter(String[] menWear,Context context,int[] images) {
        this.mMenWear = menWear;
        this.mContext= context;
        this.mImages=images;
    }

    @Override
    public int getCount() {
        return mImages.length;
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
            gridView=layoutInflater.inflate(R.layout.products_grid_view_row,null);
            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_label1);
            ImageView imageView=(ImageView)gridView
            .findViewById(R.id.imageView);
            letterView.setText(mMenWear[position]);
            imageView.setImageResource(mImages[position]);
        }else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
