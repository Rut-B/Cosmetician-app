package com.biton.rut.cosmetician_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.Blob;


public class SQLiteHelper extends SQLiteOpenHelper
{

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void queryData(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void insertData(String fName, String lName, String email , String phoneNumber,
                           String addressC, String addressS,String addressB,String addressA,
                           String isFavorite, String haveContract, String haveTreats, byte[] image)
    {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO CUSTOMERS VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, fName);
        statement.bindString(2, lName);
        statement.bindString(3, email);
        statement.bindString(4, phoneNumber);
        statement.bindString(5, addressC);
        statement.bindString(6, addressS);
        statement.bindString(7, addressB);
        statement.bindString(8, addressA);
        statement.bindString(9, isFavorite);
        statement.bindString(10, haveContract);
        statement.bindString(11, haveTreats);
        statement.bindBlob(12, image);


        statement.executeInsert();
    }

//
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   public void updateData(String name, String num,  int id)
    {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE PHONE_BOOK SET name = ?, num = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, num);
        statement.bindDouble(3, (double)id);

        statement.execute();
        database.close();
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public  void deleteData(int id)
    {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM PHONE_BOOK WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public Cursor getData(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public Cursor getDataWithParams(String sql, String[] arguments)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, arguments);
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
