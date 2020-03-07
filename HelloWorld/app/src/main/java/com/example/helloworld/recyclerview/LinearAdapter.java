package com.example.helloworld.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello world!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void OnClick(int pos);
    }
}
