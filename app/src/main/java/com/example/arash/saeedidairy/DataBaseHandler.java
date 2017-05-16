package com.example.arash.saeedidairy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Arash on 5/15/2017.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private final static String DB_NAME="MainDb";
    private final static String CREATE_FIRST_TABLE="CREATE TABLE users (username TEXT , password TEXT , phone TEXT)";
    private final static String DROP_FIRST_TABLE="DROP TABLE IF EXISTS users";
    private final static int DB_VERSION=1;


    public DataBaseHandler(Context context){
        super(context , DB_NAME , null , DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(CREATE_FIRST_TABLE);
        }catch (Exception e){

            System.out.println("Can Not Create Table !!");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {

            db.execSQL(DROP_FIRST_TABLE);
        }catch (Exception e){

            System.out.println("Can Not Upgrade Table !!");
        }
    }
    public  void  insert(){

    }
}
