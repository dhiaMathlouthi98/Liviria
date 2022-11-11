package com.example.livria;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommandeDAO {
    @Insert
    public void insertCommand( Commande commande) ;
    @Query("Select * From command_table")
    public List<Commande> GetCommands();
}
