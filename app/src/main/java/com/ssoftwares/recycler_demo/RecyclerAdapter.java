package com.ssoftwares.recycler_demo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

    private String[] Data;
    public RecyclerAdapter(String [] Data){
        this.Data=Data;

    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_layout,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, final int i) {
            String title = Data[i];
            listViewHolder.textView.setText(title);
            listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), welcome_user.class);
                    intent.putExtra("message", Data[i]);
                    listViewHolder.ctx.startActivity(intent);
                    Toast.makeText(v.getContext(),Data[i],Toast.LENGTH_SHORT).show();
                }
            });


    }

    @Override
    public int getItemCount() {
        return Data.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            Context ctx= itemView.getContext();
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
             textView = (TextView)itemView.findViewById(R.id.text_viewS);
        }
    }
}
