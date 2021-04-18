package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {



    public final static  String DBNAME = "mydatabase.db";
    final static  int DBVERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +   //name=1
                        "image int," +   //image=2
                        "price int," +   //price=3
                        "phone int," +   //phone=4
                        "quantity int," +    //quantity=5
                        "description text," +  //description=6
                        "foodName text)"      //foodname=7
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orders ");
        onCreate(db);
    }


    public boolean insertOrder(String name ,String phone , int price , int image , String description , String foodName, int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("image",image);
        values.put("price",price);
        values.put("phone",phone);
        values.put("description",description);
        values.put("foodName",foodName);
        values.put("quantity",quantity);
        long id = database.insert("orders","null",values);
        return id > 0;

    }


      public ArrayList<OrdersModel> getorders(){
        ArrayList<OrdersModel> orders =new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(" select id,foodName,image,price from orders ",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrder_Model_Number(cursor.getInt(0)+"");
                model.setOrder_Model_Name(cursor.getString(1));
                model.setOrder_Model_Image(cursor.getInt(2));
                model.setOrder_Model_Price(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

      //updation
    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(" select * from orders where id = "+id,null);

           if(cursor !=null)

               cursor.moveToFirst();
               return cursor;

    }


    public boolean updateOrder(String name ,String phone , int price , int image , String description , String foodName, int quantity,int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("image",image);
        values.put("price",price);
        values.put("phone",phone);
        values.put("description",description);
        values.put("foodName",foodName);
        values.put("quantity",quantity);
        long row = database.update("orders",values,"id="+id,null);
        return row > 0;

    }

    //deletion operation
    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }


}




















