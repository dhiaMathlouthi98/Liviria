package com.example.livria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {


    //Var
     List<Commande> commandes = new ArrayList<>();

     private Form form ;


    //Widgets
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        commandes= form.AfficherCommandes() ;

        //binding

        recyclerView = findViewById(R.id.recycler);

        //recyclerview Config

        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));
        recyclerView.setAdapter( new MyAdapter(this , commandes));

    }
}