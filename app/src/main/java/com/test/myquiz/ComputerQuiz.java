package com.test.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.test.myquiz.databinding.ActivityComputerQuizBinding;

public class ComputerQuiz extends AppCompatActivity {
    ActivityComputerQuizBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_quiz);

        binding.timeCountCom.setText("1");
    }
}