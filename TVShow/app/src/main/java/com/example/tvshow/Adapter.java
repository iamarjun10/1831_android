package com.example.tvshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    View view;
    List<Model> list;
    Context context;

    public Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.Name.setText(list.get(position).getName());
        holder.nickname.setText(list.get(position).getNickName());
        holder.realname.setText(list.get(position).getRealName());

        Picasso.get().load(list.get(position).img).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView Name,nickname,realname;
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            nickname = itemView.findViewById(R.id.nickname);
            realname = itemView.findViewById(R.id.realName);
            imageView = itemView.findViewById(R.id.ImageView);
        }
    }
}
