package com.example.task71p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNote extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        EditText newnoteinput = findViewById(R.id.inputnewnote);
        Button Addbutton = findViewById(R.id.addnotebutton);
        mDatabaseHelper = new DatabaseHelper(this);

        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = newnoteinput.getText().toString();
                if (newnoteinput.length() != 0) {
                    boolean insertData = mDatabaseHelper.addData(newEntry);

                    if (insertData) {
                        Toast.makeText(NewNote.this, "New note added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NewNote.this, "fail to add new note", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}