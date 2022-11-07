package com.test.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.test.myquiz.databinding.ActivityLoginPageBinding;

public class LoginPage extends AppCompatActivity {

    ActivityLoginPageBinding binding;
    RadioButton userGender;
    boolean genderSelected= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login_page);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                userGender = findViewById(i);
                genderSelected = true;
            }
        });


//************************** Using Shared preferences *******************************
        SharedPreferences preferences = getSharedPreferences("LoginPagePreference",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        binding.btnLogin.setOnClickListener(view -> {

            if (binding.loginUserName.getText().toString().equals("")){
                showUserWarning("Please enter your name first");
            }
            else if (genderSelected == false){
                showUserWarning("Please select a gender");
            }
            else{
                String userName = binding.loginUserName.getText().toString();
                String genderName = userGender.getText().toString();

                editor.putString("UserName",userName);
                editor.putString("UserGender", genderName);
                editor.apply();

                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void showUserWarning(String warningText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setTitle("Warning!!");
        builder.setMessage(warningText);
        builder.setIcon(R.drawable.warning_icon);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("TAG", "Okay button was pressed...");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}