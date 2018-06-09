package com.example.progmobile.startruck.model.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.progmobile.startruck.model.bean.Enterprise;

public class BDHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "StarTruckDB.db";

    SQLiteDatabase bd;

    private static BDHelper instance;

    public BDHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static BDHelper getInstance(Context context){
        if(instance==null)
            instance = new BDHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.bd = db;
        bd.execSQL(UserDAO.TABLE_CREATE_USER);
        bd.execSQL(EnterpriseDAO.TABLE_CREATE_ENTERPRISE);
        bd.execSQL(DriverDAO.TABLE_CREATE_DRIVER);
        System.out.println(" tables created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.bd = db;
        bd.execSQL(UserDAO.TABLE_DROP_USER);
        bd.execSQL(EnterpriseDAO.TABLE_DROP_ENTERPRISE);
        bd.execSQL(DriverDAO.TABLE_DROP_DRIVER);
        onCreate(db);
    }
}