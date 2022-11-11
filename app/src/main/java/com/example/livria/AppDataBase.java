package com.example.livria;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Commande.class} , version = 1 ,exportSchema = false)
public  abstract class AppDataBase extends RoomDatabase {

    //Var
    private static AppDataBase instance ;
    private static String DATABASE_NAME = "CommandeDataBase" ;
    public abstract CommandeDAO commandeDAO() ;

    public static AppDataBase GetInstance(Context context ) {
        if ( instance == null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class , DATABASE_NAME).allowMainThreadQueries().build();
        }

        return  instance ;
    }
}
