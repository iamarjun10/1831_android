package com.example.tomandjerry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JerryAdapter extends RecyclerView.Adapter<JerryAdapter.JerryViewHolder> {

    ArrayList<Message> texts;
    String user;
    int count = 0;

    public JerryAdapter(ArrayList<Message> texts, String user) {
        this.texts = texts;
        this.user = user;
    }

    @Override
    public int getItemViewType(int position) {
        count=position;
        if (texts.get(count).user == user) {
            return 0;
        }
        else
            return 1;
    }

    @NonNull
    @Override
    public JerryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =null;
        if(viewType==0){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.right_chat_bubble,parent,false);
        }
        else{
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.left_chat_bubble,parent,false);
        }
        JerryAdapter.JerryViewHolder viewHodler = new JerryAdapter.JerryViewHolder(view);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull JerryViewHolder holder, int position) {
        holder.txtTitle.setText(texts.get(position).message);
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    public class JerryViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        public JerryViewHolder(@NonNull View itemView) {
            super(itemView);
            if(texts.get(count).user==user){
                txtTitle = itemView.findViewById(R.id.txtTitle);
            }
            else{
                txtTitle = itemView.findViewById(R.id.txtTitle);
            }
         }
    }
}
