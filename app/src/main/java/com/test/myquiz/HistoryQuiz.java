package com.test.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.test.myquiz.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryQuiz extends AppCompatActivity {

    ActivityHistoryBinding historyBinding;
    List<QuestionsHistory> quizs;

    int currentIndex;
    String ansStr;
    int ansScore=0, selectedBox;
    int newTime=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_history);
        historyBinding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(historyBinding.getRoot());

//        ----------------------------CountDownTimer timer ----------
            myTimer();

//        ------------------------- Creating questions---------------------------
        quizs = new ArrayList<>();
        quizs.add(new QuestionsHistory("What is the capital of Bangladesh?","Khulna","Dhaka","Cumilla","Noakhali","Dhaka"));
        quizs.add(new QuestionsHistory("What is the national language of Bangladesh?","Hindi","English","Bangla","Arabic","Bangla"));
        quizs.add(new QuestionsHistory("What is the national animal of Bangladesh?","Royal Bengal Tiger","Haming Bird","Zebra","Lion","Royal Bengal Tiger"));
        quizs.add(new QuestionsHistory("Who is the current precedent of Bangladesh?","Abdul Hamid","Kamrul Hasan","Zillur Rahman","General Usmani","Abdul Hamid"));
        quizs.add(new QuestionsHistory("Who is the first Bangladeshi to summit the Everest?", "Musa Ibrahim","Abdul Hamid","Kamrul Hasan","Shakil Shah","Musa Ibrahim"));
        quizs.add(new QuestionsHistory("What is Cox's bazaar?","Longest sea beach","A drawing","A bazar","A shop name","Longest sea beach"));
        quizs.add(new QuestionsHistory("What is the old name of Dhaka?","Jahangir Nagar","Sultanganj","Mujib Nagar","Kokata","Jahangir Nagar"));
        quizs.add(new QuestionsHistory("পূর্ব পাকিস্তানের প্রথম মুখ্যমন্ত্রীর নাম কি?","স্যার খাজা নাজিমুদ্দিন"," নুরুল আমিন","এ.কে ফজলুল হক","আতাউর রহমান","স্যার খাজা নাজিমুদ্দিন"));
        quizs.add(new QuestionsHistory("পাকিস্তানকে প্রজাতন্ত্র ঘোষণা করা হয় কবে","১৯৪৮ সালে","১৯৫৬ সালে","১৯৫৫ সালে","১৯৫৮ সালে","১৯৫৬ সালে"));
        quizs.add(new QuestionsHistory("মৌলিক গণতন্ত্র কবে ঘোষণা করা হয়?","১৯৫৬ সালে","১৯৪৮ সালে","১৯৫৫ সালে","১৯৫৯ সালে","১৯৫৯ সালে"));

//     ---------------------   placing the question and options to their individual places---------------
//        Log.i("TAG","Size"+ String.valueOf(quizs.size()));
//        for (int item = 0; item<quizs.size(); item++){
//        setQuestionAndOptions(currentIndex);
//        }
        setQuestionAndOptions(currentIndex);

//       -------------------------------- handling multiple option clicks --------------------------------
        historyBinding.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyBinding.option1.setBackgroundResource(R.drawable.on_click_option_button);
//                Checking if it is right answer
                ansStr = historyBinding.option1.getText().toString();
                selectedBox =1;

                historyBinding.option2.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option3.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option4.setBackgroundResource(R.drawable.option_button_shapping);
            }
        });
                historyBinding.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyBinding.option2.setBackgroundResource(R.drawable.on_click_option_button);
                ansStr = historyBinding.option2.getText().toString();
                selectedBox = 2;

               String test= quizs.get(currentIndex).getCorrectAns();

                historyBinding.option1.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option3.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option4.setBackgroundResource(R.drawable.option_button_shapping);
            }
        });
                historyBinding.option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyBinding.option3.setBackgroundResource(R.drawable.on_click_option_button);
                ansStr = historyBinding.option3.getText().toString();
                selectedBox = 3;

                historyBinding.option1.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option2.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option4.setBackgroundResource(R.drawable.option_button_shapping);
            }
        });
                historyBinding.option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyBinding.option4.setBackgroundResource(R.drawable.on_click_option_button);
                ansStr = historyBinding.option4.getText().toString();
                selectedBox = 4;

                historyBinding.option1.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option2.setBackgroundResource(R.drawable.option_button_shapping);
                historyBinding.option3.setBackgroundResource(R.drawable.option_button_shapping);
            }
        });
//----------------Handeling popup close button----------------------------
                historyBinding.popUpClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HistoryQuiz.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
//        -----------------Checking the right answer-----------------------
        historyBinding.nextSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRightAnswer();
//                setQuestionAndOptions(currentIndex);
//                Log.i("TAG", "Button: "+currentIndex);
            }
        });
    }
    //    **********************************************************************************************
//    ************************************ onCreate function end ***********************************
    private void myTimer() {
        this.newTime = 1;
        new CountDownTimer(60000, 1000){
            @Override
            public void onTick(long l) {
                historyBinding.timeCount.setText("Time: "+ (60-newTime));
                newTime +=1;
            }

            @Override
            public void onFinish() {
                currentIndex = quizs.size() ;
                setQuestionAndOptions(currentIndex);
            }
        }.start();
    }


    private void checkRightAnswer() {
        Log.i("TAG", "Index no: "+ currentIndex);
        if (quizs.get(currentIndex).getCorrectAns().equals(ansStr)){
            currentIndex +=1;
//            myTimer();

            this.ansScore +=10;
            historyBinding.scoreBox.setText(String.valueOf(ansScore));

            historyBinding.option1.setBackgroundResource(R.drawable.option_button_shapping);
            historyBinding.option2.setBackgroundResource(R.drawable.option_button_shapping);
            historyBinding.option3.setBackgroundResource(R.drawable.option_button_shapping);
            historyBinding.option4.setBackgroundResource(R.drawable.option_button_shapping);
            setQuestionAndOptions(currentIndex);
        }
        else {

            if (selectedBox==1){
                historyBinding.option1.setBackgroundResource(R.drawable.on_wrong_ans_option_button);

                //                ansScore -=5;
//                historyBinding.scoreBox.setText(ansScore);
                wrongAnsHandling();
            }
            else if (selectedBox==2){
                historyBinding.option2.setBackgroundResource(R.drawable.on_wrong_ans_option_button);

//                ansScore -=5;
//                historyBinding.scoreBox.setText(ansScore);
                wrongAnsHandling();
            }
            else if (selectedBox==3){
                historyBinding.option3.setBackgroundResource(R.drawable.on_wrong_ans_option_button);
                wrongAnsHandling();

            }
            else if (selectedBox==4){
                historyBinding.option4.setBackgroundResource(R.drawable.on_wrong_ans_option_button);
                wrongAnsHandling();

            }else {
                Toast.makeText(this, "Please select a ans first", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void wrongAnsHandling() {
        ansScore -=20;
        historyBinding.scoreBox.setText(String.valueOf(ansScore));

        Toast.makeText(this, "Wrong answer!!", Toast.LENGTH_SHORT).show();
    }

    //        Setting up question and options via function
    public void setQuestionAndOptions(int currentIndex) {
//        myTimer();

        if (currentIndex<quizs.size()){
        historyBinding.question.setText(quizs.get(currentIndex).getQuestion());
        historyBinding.option1.setText(quizs.get(currentIndex).getOption1());
        historyBinding.option2.setText(quizs.get(currentIndex).getOption2());
        historyBinding.option3.setText(quizs.get(currentIndex).getOption3());
        historyBinding.option4.setText(quizs.get(currentIndex).getOption4());
        }
        else {

                historyBinding.scrollbar.setVisibility(View.GONE);
                historyBinding.popUpLayout.setVisibility(View.VISIBLE);
                historyBinding.popUpText.setText("Your score: " + ansScore);

        }
    }
}