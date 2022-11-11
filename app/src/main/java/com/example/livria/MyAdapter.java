package com.example.livria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //Var
    private Context context;
    private List<Commande> commandes ;

    //Const

    public MyAdapter(Context context, List<Commande> commandes) {
        this.context = context;
        this.commandes = commandes;
    }

    //ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        //Widgets
        private TextView textv1 ;
        private TextView textv2 ;
        private TextView textv3 ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textv1 =itemView.findViewById(R.id.textv1);
            textv2 =itemView.findViewById(R.id.textv2);
            textv3 =itemView.findViewById(R.id.textv3);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new ViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Commande c = commandes.get(position);
        holder.textv1.setText(c.getNomClient());
        holder.textv2.setText(c.getDate());
        holder.textv3.setText(c.getCommentaire());
    }

    @Override
    public int getItemCount() {
        return commandes.size();
    }
}
