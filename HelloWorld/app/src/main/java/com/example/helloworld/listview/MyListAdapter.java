package com.example.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class MyListAdapter extends BaseAdapter {

    private Context mcontext;

    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context) {
        this.mcontext = context;
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
        public TextView tvTitle, tvTime, tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.iv);
            viewHolder.tvTime = convertView.findViewById(R.id.tv_time);
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_time);
            viewHolder.tvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 给控件赋值
        viewHolder.tvTitle.setText("这是标题");
        viewHolder.tvTime.setText("2020-01-01");
        viewHolder.tvContent.setText("这是内容");
        Glide.with(mcontext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583253581148&di=0478e7c03eecd03ca7e493fc346425ab&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F03%2F12%2F16pic_312797_b.jpg").into(viewHolder.imageView);
        return convertView;
    }
}
