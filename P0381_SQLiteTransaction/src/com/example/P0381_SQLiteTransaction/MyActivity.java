package com.example.P0381_SQLiteTransaction;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MyActivity extends Activity {
    final String LOG_TAG = "myLogs";

    DBHelper dbh;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(LOG_TAG, "--- OnCreate Activity ---");
        dbh = new DBHelper(this);
        myactions();

    }
    void myactions() {
        try {
            db = dbh.getWritableDatabase();
            delete(db, "mytable");
            db.beginTransaction();
            insert(db, "mytable", "val1");

            Log.d(LOG_TAG, "Create dbHelper");
            DBHelper dbh2 = new DBHelper(this);
            Log.d(LOG_TAG, "get db");
            SQLiteDatabase db2 = dbh2.getWritableDatabase();
            read(db2, "mytable");
            dbh2.close();

            db.setTransactionSuccessful();
            db.endTransaction();
            read(db, "mytable");
            dbh.close();
        } catch (Exception e) {
            Log.d(LOG_TAG, e.getClass() + " error: " + e.getMessage());
        }
    }
    void insert(SQLiteDatabase db, String table, String value) {
        Log.d(LOG_TAG, "Insert in table: " + table + " value: " + value);
        ContentValues cv = new ContentValues();
        cv.put("val", value);
        db.insert(table, null, cv);
    }
    void read(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Reading table: " + table);
        Cursor c = db.query(table, null, null, null, null, null, null);
        if(c != null) {
            Log.d(LOG_TAG, "Records count = " + c.getCount());
            if(c.moveToFirst()) {
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")));
                } while(c.moveToNext());
            }
            c.close();
        }
    }
    void delete(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Delete all from table: " + table);
        db.delete(table, null, null);
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "mydb", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(LOG_TAG, "--- On create Database ---");

            sqLiteDatabase.execSQL("create table mytable ("
            + "id integer primary key autoincrement,"
            + "val text"
            + ");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
