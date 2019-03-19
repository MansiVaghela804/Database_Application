package com.example.manu.databaseapplication;

import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2;
    EditText title, description;
    MyDatabaseHelper dbhelper;
    TableNotes[] notes = new TableNotes[10];
    String fnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper  = new MyDatabaseHelper(MainActivity.this);
        title = findViewById(R.id.editText);
        description = findViewById(R.id.editText2);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableNotes note = new TableNotes();
                note.setTitle(title.getText().toString());
                note.setDescription(description.getText().toString());
                Toast.makeText(MainActivity.this, "ADD NOTE", Toast.LENGTH_SHORT).show();
                dbhelper.insertNote(note);
            }
        });

        btn2 = findViewById(R.id.vbutton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fnote = "";
                Cursor c = dbhelper.getNotes();
                if(c.isBeforeFirst()){
                    c.moveToFirst();
                }
                do{
                    TableNotes note = new TableNotes();
                    String mtitle = c.getString(c.getColumnIndex(TableNotes.COLUMN_TITLE));
                    String mdesc = c.getString(c.getColumnIndex(TableNotes.COLUMN_DESCRIPTION));
                    note.setTitle(mtitle);
                    note.setDescription(mdesc);
                    fnote = fnote + note.getTitle() + " - "  + note.getDescription() + " \n";
                    Toast.makeText(MainActivity.this, "VIEW ALL NOTES", Toast.LENGTH_SHORT).show();
                }while(c.moveToNext());

                TextView tv = findViewById(R.id.textView);
                tv.setText(fnote);
            }
        });
    }
}
