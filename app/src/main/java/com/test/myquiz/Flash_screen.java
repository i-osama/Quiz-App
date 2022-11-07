package com.test.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Flash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        new Handler().postDelayed(() ->{
            Intent intent = new Intent(Flash_screen.this, LoginPage.class);
            startActivity(intent);
            finish();
        }, 1800);
    }
}