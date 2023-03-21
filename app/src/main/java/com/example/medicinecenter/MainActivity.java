package com.example.medicinecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity  {


    private ProgressBar homeBar;
    private double Progress_Status = 0;
    private Handler homeHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progBarAnimation();


      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
              startActivity(intent);
              finish();
          }
      },5000);
    }

    public void progBarAnimation(){
        homeBar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(Progress_Status < 100){
                    Progress_Status+=1;
                    android.os.SystemClock.sleep(50);
                    homeHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            homeBar.setProgress((int)Progress_Status);
                        }
                    });
                }
            }
        }).start();
    }


}