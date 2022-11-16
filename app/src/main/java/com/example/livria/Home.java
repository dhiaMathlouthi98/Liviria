package com.example.livria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {


    //Var

     List<Commande> commandes = new ArrayList<>();
    private AppDataBase database ;


     private Form form ;


    //Widgets
    private RecyclerView recyclerView ;
    private Button ajouterBtn ;
    private Button modifierBtn ;
    private Button supprimerBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //init DataBase
        database = AppDataBase.GetInstance(this);


        commandes=this.AfficherCommandes() ;


        //binding

        recyclerView = findViewById(R.id.recycler);
        ajouterBtn = findViewById(R.id.ajouterBtn);
        modifierBtn = findViewById(R.id.modifierBtn);
        supprimerBtn = findViewById(R.id.supprimerBtn);

        //Actions
        ajouterBtn.setOnClickListener( view -> {
            Intent intent = new Intent(this ,Form.class);
            startActivity(intent);
        });




        //recyclerview Config

        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));
        recyclerView.setAdapter( new MyAdapter(this , commandes));

    }
    //Methods
    public List<Commande> AfficherCommandes (){

        return database.commandeDAO().GetCommands();
    }
}