package com.example.livria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.List;

public class Form extends AppCompatActivity {


    //var
    private AppDataBase database ;
    static final String NomClient_KEY = "NomClient" ;
    static final String LIVRE_KEY = "Livre" ;
    static final String DATE_KEY = "Date" ;
    static final String COMMENTAIRE_KEY = "Commentaires " ;

    //Widgets
    private EditText NomClientET ;
    private CheckBox LivreCB ;
    private DatePicker datePicker ;
    private EditText CommentaireET ;
    private Button ValiderBtn ;
    private Button AnnulerBtn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //bind
        NomClientET = findViewById(R.id.NomClientET) ;
        LivreCB = findViewById(R.id.LivreCB) ;
        datePicker = findViewById(R.id.datePicker);
        CommentaireET = findViewById(R.id.CommentaireET);
        ValiderBtn = findViewById(R.id.ValiderBtn);
        AnnulerBtn = findViewById(R.id.AnnulerBtn);

        //init DataBase

        database = AppDataBase.GetInstance(this);

        //Actions
       ValiderBtn.setOnClickListener(view -> {

           Intent intent = new Intent(this ,Home.class);

           Commande c = new Commande( NomClientET.getText().toString() ,LivreCB.getText().toString() , datePicker.toString() ,CommentaireET.getText().toString()) ;
           AjouterCommande(c);
           startActivity(intent);
        });

       AnnulerBtn.setOnClickListener(view -> {
           Intent intent = new Intent(this ,Home.class);
           startActivity(intent);
           finish();

       });

    }

    //Methods

    public void AjouterCommande(Commande commande){

        database.commandeDAO().insertCommand(commande);
    }

    public List<Commande> AfficherCommandes (){

        return database.commandeDAO().GetCommands();
    }
}