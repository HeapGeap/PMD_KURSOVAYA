package com.example.medicinecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medicinecenter.Database.DatabaseBack;
import com.example.medicinecenter.Database.DatabaseManager;

public class DatabaseSave extends AppCompatActivity {

    public DatabaseManager myDbManager;
    private EditText edName, edSurname,edWI,edHours;
    private EditText edName2 , edDate, edDateTime;
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

        edName2 = findViewById(R.id.editTextTextPersonName);
        edDate = findViewById(R.id.editTextTextPersonName2);
        edDateTime = findViewById(R.id.editTextTextPersonName3);

        DbOut = findViewById(R.id.DatabaseOut);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
    }


    public void savingData(View v){

        myDbManager.DatabaseInsert(edName.getText().toString(),edSurname.getText().toString(),
                edWI.getText().toString(),edHours.getText().toString());

        myDbManager.DatabaseInsert2(edName2.getText().toString(),edDate.getText().toString(),edDateTime.getText().toString());

        for(String name : myDbManager.getDataFromDb()){
            DbOut.append(name);
            DbOut.append("\n");
        }

        for(String name : myDbManager.getDataFromDb2()){
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