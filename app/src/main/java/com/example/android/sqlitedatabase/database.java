package com.example.android.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname= "signup.db";  //Name of the Database...
    public database(@Nullable Context context) {
        super(context,dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //This is used to creat a database or tables...
        String q= "create table users (id integer primarykey autoincrement, username text, password text)";
        //A simple Sql query to create table in database named signup (above line...)
        db.execSQL(q);  // To execute the database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    public boolean insert_data(String name, String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put("username" , name);
        c.put("password", password);
        long r=db.insert("users",null,c);// this insert function returns 0 or -1
        if(r==-1)return false;
        else
            return true;
    }


    public Cursor getinfo()
    {
        SQLiteDatabase dbview= this.getWritableDatabase();
        Cursor cursor= dbview.rawQuery("Select * from users", null);
        return cursor;
    }
}
