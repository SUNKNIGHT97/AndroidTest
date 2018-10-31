package com.example.teamo.diary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Database {
    private SQLiteDatabase db;
    private Context context;
    public Database(Context context,SQLiteDatabase db) {
        this.db = db;
        this.context = context;
    }
    public void create_db(){
        db = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir().toString()+"/mynotes.db3", null);
        db.execSQL("DROP TABLE IF EXISTS studentScore");

        if(db == null){
            Toast.makeText(context,"数据库创建不成功",Toast.LENGTH_LONG).show();
        }

        db.execSQL("create table if not exists notes(_id integer primary key autoincrement," +
                "title text," +
                "context text," +
                "time varchar(20))");

    }
    public void insert_db(String title,String text,String time){

        if(text.isEmpty()){
            Toast.makeText(context, "各字段不能为空", Toast.LENGTH_LONG).show();
        }
        else{
            db.execSQL("insert into notes(title,context,time) values('"+ title+"','"+ text+ "','"+time+"');");
        }

    }
    public void update_db(String title,String text,String time,int item_ID){
        if( text.isEmpty()){
            Toast.makeText(context, "各字段不能为空", Toast.LENGTH_LONG).show();
        }
        else{
            db.execSQL("update notes set context='"+text+ "',title='"+title+"',time='"+time+"'where _id='" + item_ID+"'");
        }
    }

    public Cursor query_db(){
        Cursor cursor = db.rawQuery("select * from notes",null);
        return cursor;
    }
    public Cursor query_db(int item_ID){
        Cursor cursor = db.rawQuery("select * from notes where _id='"+item_ID+"';",null);
        return cursor;

    }
    public void delete_db(int item_ID){
        db.execSQL("delete from notes where _id='" + item_ID+"'");
        Toast.makeText(context, "删除成功", Toast.LENGTH_LONG).show();
    }
    public void close_db(){
        db.close();
    }
}