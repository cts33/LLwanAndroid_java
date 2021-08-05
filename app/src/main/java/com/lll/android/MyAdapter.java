package com.lll.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lll.android.bean.MotoBean;

import org.jetbrains.annotations.NotNull;

import kotlinx.coroutines.CoroutineDispatcher;

public class MyAdapter extends PagingDataAdapter<MotoBean.Datam, MyAdapter.ViewHolder> {

    Context context;

    public MyAdapter( Context context) {
        super(new DiffUtil.ItemCallback<MotoBean.Datam>(){
            @Override
            public boolean areItemsTheSame(@NonNull @NotNull MotoBean.Datam oldItem, @NonNull @NotNull MotoBean.Datam newItem) {
                return oldItem.getGoodId()==newItem.getGoodId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull @NotNull MotoBean.Datam oldItem, @NonNull @NotNull MotoBean.Datam newItem) {
                return oldItem.getGoodId()==newItem.getGoodId();
            }
        });
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.moto_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        MotoBean.Datam item = getItem(position);

        holder.title.setText(item.getGoodName()+"  "+item.getBrandName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textView);
        }
    }
}
