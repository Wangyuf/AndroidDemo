package com.example.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyGridViewAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.iv_grid);
            viewHolder.textView = convertView.findViewById(R.id.tv_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText("钢铁侠");
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583253581148&di=0478e7c03eecd03ca7e493fc346425ab&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F03%2F12%2F16pic_312797_b.jpg").into(viewHolder.imageView);
        return convertView;
    }
}
