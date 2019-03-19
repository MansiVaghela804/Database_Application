package com.example.manu.databaseapplication;

public class TableNotes {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";


//  Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_DESCRIPTION + " TEXT"
                    + ")";


    private int id;
    private String title, description;


    public TableNotes(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public TableNotes() {
    }

//   To Do getId
    public int getId() {
        return id;
    }
//  To Do setId
    public void setId(int id) {
        this.id = id;
    }

//  To Do getTitle
    public String getTitle() {
        return title;
    }
//  To Do setTitle
    public void setTitle(String title) {
        this.title = title;
    }
//  To Do getDescription
    public String getDescription() {
        return description;
    }
//  To Do setDescription
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "TableNotes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
