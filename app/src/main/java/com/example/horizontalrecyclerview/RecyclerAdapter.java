package com.example.horizontalrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
        Context context;
        List<JunkAttributes> junkAttributes;
        int row_index;



    public RecyclerAdapter(Context context, List<JunkAttributes> junkAttributes) {
        this.context = context;
        this.junkAttributes = junkAttributes;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JunkAttributes j=junkAttributes.get(position);
        holder.image.setImageResource(j.getImage());
        holder.name.setText(j.getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index=position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            holder.linearLayout.setBackgroundResource(R.drawable.circle_bg);

        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.not_selected);
        }
    }

    @Override
    public int getItemCount() {
        return junkAttributes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        LinearLayout linearLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textView);
            image=itemView.findViewById(R.id.imageView);
            linearLayout=itemView.findViewById(R.id.linearLayout);



        }
    }
}
