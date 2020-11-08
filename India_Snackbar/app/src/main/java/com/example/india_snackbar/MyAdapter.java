package com.example.india_snackbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Model> list;
    View view;
    Model temp;

    public MyAdapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.city_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.name.setText(list.get(position).getName());
        holder.gender.setText(list.get(position).getGender());
        holder.pic.setImageResource(list.get(position).getImage());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=new Model(list.get(position).getName(),list.get(position).getGender(),list.get(position).getImage());
                deleteCity(position,view);
            }
        });

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=new Model(list.get(position).getName(),list.get(position).getGender(),list.get(position).getImage());
                editStudent(position,view);
            }
        });
    }

    private void editStudent(int position, View view) {
        Intent i= new Intent(view.getContext(),EditActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("position",position);
        i.putExtra("name",list.get(position).getName());
        i.putExtra("gender",list.get(position).getGender());
        i.putExtra("image",list.get(position).getImage());
        Toast.makeText(view.getContext(), ""+position, Toast.LENGTH_SHORT).show();

        context.startActivity(i);
    }

    private void deleteCity(final int position, View view) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());

        Snackbar snackbar = Snackbar.make(view,temp.getName() +" deleted successfully" ,Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(position,temp);
                notifyItemInserted(position);
                notifyItemRangeChanged(position,list.size());
            }
        });
        snackbar.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,gender;
        ImageView pic,deleteButton,editButton;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            gender = itemView.findViewById(R.id.gender);
            pic = itemView.findViewById(R.id.imageView);
            editButton = itemView.findViewById(R.id.edit);
            deleteButton = itemView.findViewById(R.id.deleteButton);

        }
    }
}
