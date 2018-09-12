package com.example.android.homegridexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private final Context mContext;
    private final GridCell[] categories;

    //
    public GridAdapter(Context context, GridCell[] categories) {
        this.mContext = context;
        this.categories = categories;
    }

    // 2
    @Override
    public int getCount() {
        return categories.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView cellView = new ImageView(mContext);
        cellView.setImageResource(categories[position].getImage());
        return cellView;
    }

}
