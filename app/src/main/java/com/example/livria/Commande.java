package com.example.livria;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Command_Table")
public class Commande {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name = "ClientName")
    private String NomClient ;
    @ColumnInfo(name = "ISLivred")
    private String Livré ;
    @ColumnInfo(name = "Date")
    private String Date ;
    @ColumnInfo(name = "Comment")
    private String Commentaire ;

    //cnstrct
    public Commande(String nomClient, String livré, String date, String commentaire) {

        NomClient = nomClient;
        Livré = livré;
        Date = date;
        Commentaire = commentaire;
    }

    public Commande() {
    }

    //Getters And Setters

    public int getId() {
        return id;
    }

    public String getNomClient() {
        return NomClient;
    }

    public String getLivré() {
        return Livré;
    }

    public String getDate() {
        return Date;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomClient(String nomClient) {
        NomClient = nomClient;
    }

    public void setLivré(String livré) {
        Livré = livré;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setCommentaire(String commentaire) {
        Commentaire = commentaire;
    }


    //ToString


    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", NomClient='" + NomClient + '\'' +
                ", Livré=" + Livré +
                ", Date='" + Date + '\'' +
                ", Commentaire='" + Commentaire + '\'' +
                '}';
    }
}
