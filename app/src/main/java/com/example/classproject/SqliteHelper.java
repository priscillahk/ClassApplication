package com.example.classproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context){
        super(context,"music_db",null,1);
    }
    public void onCreate(SQLiteDatabase db){
//        SQL statement to insert the songs in the table called songs
db.execSQL("CREATE table songs(id integer primary key autoincrement not null, Title varchar(100) not null,Artist varchar(100) not null,Chorus varchar(255) not null)");
    }
    public void onUpgrade(SQLiteDatabase db,int newVersion,int oldVersion){
        db.execSQL("DROP table if  exists users");
        onCreate(db);
    }
//    method called to save songs in the table
    public boolean saveSong(String title,String art,String chro){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Title",title);
        contentValues.put("Artist",art);
        contentValues.put("Chorus",chro);
    long send=db.insert("songs",null,contentValues);
    if (send==-1)
        return false;
    else
        return true;
    }
}