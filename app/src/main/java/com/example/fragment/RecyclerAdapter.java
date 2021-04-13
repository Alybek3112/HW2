package com.example.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ItemModel> list;
    private OnclickListener listener;

    public RecyclerAdapter(List<ItemModel> list, OnclickListener listener) {
        this.list = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model,parent,false);
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title2,lastTxt2;
        private  OnclickListener listener;
        public ViewHolder(@NonNull View itemView,OnclickListener listener) {
            super(itemView);
            this.listener = listener;
            title2 = itemView.findViewById(R.id.title_txt);
            lastTxt2 = itemView.findViewById(R.id.last_txt);

        }

        public void onBind(ItemModel itemModel) {
            title2.setText(itemModel.getTitleTitle());
            lastTxt2.setText(itemModel.getLastText());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.clickItem(itemModel);
                }
            });
        }
    }


    interface OnclickListener{
        void clickItem(ItemModel item);
    }
}
