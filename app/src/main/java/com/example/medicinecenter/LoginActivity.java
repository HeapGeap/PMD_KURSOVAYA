package com.example.medicinecenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    int signTries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth_block();

    }

    public void auth_block() {

        final Button auth = (Button) findViewById(R.id.auth_button);
        final Button reg = (Button) findViewById(R.id.reg);

        EditText name = findViewById(R.id.name_field);
        EditText pass = findViewById(R.id.pass_field);


        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().equals("qwert") && pass.getText().toString().equals("12345")) {
                    Intent intent = new Intent(LoginActivity.this, UserProfile.class);
                    startActivity(intent);
                    signTries = 0;
                }

                if ((name.getText().length()) != 0 && (pass.getText().length()) != 0) {
                    signTries++;
                    if (signTries == 7) {
                        auth.setEnabled(false);
                    }
                }
            }

        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }
}
