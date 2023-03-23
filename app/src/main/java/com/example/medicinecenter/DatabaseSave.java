package com.example.medicinecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medicinecenter.Database.DatabaseBack;
import com.example.medicinecenter.Database.DatabaseManager;

public class DatabaseSave extends AppCompatActivity {

    private DatabaseManager myDbManager;
    private EditText edName, edSurname,edWI,edHours;
    private TextView DbOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_save);
        myDbManager = new DatabaseManager(this);

        edName = findViewById(R.id.editTextName);
        edSurname = findViewById(R.id.editTextSurname);
        edWI = findViewById(R.id.editTextWI);
        edHours = findViewById(R.id.editTextHours);
        DbOut = findViewById(R.id.DatabaseOut);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();


    }

    public void logData(View v){

        for(String name: myDbManager.getDataFromDb()){
            DbOut.append(name);
            DbOut.append("\n");
        }
    }

    public void savingData(View v){

        myDbManager.DatabaseInsert(edName.getText().toString(),edSurname.getText().toString(),
                edWI.getText().toString(),edHours.getText().toString());

        for(String name: myDbManager.getDataFromDb()){
            DbOut.append(name);
            DbOut.append("\n");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDatabase();
    }
}