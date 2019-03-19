package com.example.manu.databaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class MyDatabaseHelper extends SQLiteOpenHelper {
//  Database Name
    private static final String DB_NAME  = "databaseapplication";
//  Database Version
    private static final int VERSION = 1;

//    Constructor
    public MyDatabaseHelper(Context ctx){
        super(ctx,DB_NAME,null,VERSION);
    }

//    onCreate Method
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableNotes.CREATE_TABLE);
    }

//   onUpgrade Method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableNotes.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


//  To insert a note in the table
    public void insertNote(TableNotes note){
//  get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TableNotes.COLUMN_TITLE, note.getTitle());
        cv.put(TableNotes.COLUMN_DESCRIPTION, note.getDescription());
//      Insert Row
        db.insert(TableNotes.TABLE_NAME,null,cv);

//        DB Connection Close
        db.close();
    }

    public Cursor getNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TableNotes.TABLE_NAME,
                new String[]{TableNotes.COLUMN_TITLE,TableNotes.COLUMN_DESCRIPTION},
                null,null,null,null,null);
        return cursor;
    }
}
