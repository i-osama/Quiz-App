package com.test.myquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    LinearLayout historyLayout, astroLayout, computerLayout, lawLayout;
    Intent intent;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyLayout = findViewById(R.id.quiz_Thistory);
        astroLayout = findViewById(R.id.quiz_Tastronomy);
        computerLayout = findViewById(R.id.quiz_Tcomputer);
        lawLayout = findViewById(R.id.quiz_Tlaw);

//  ---------------------------------- toolbar settings ----------------------------
        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.nav_open, R.string.nav_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//--------------------- Bottom navigation settings ---------------------------
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_menu);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.bottom_light_menu:
                        drawerLayout.setBackgroundResource(R.drawable.nav_home_back_gradient);
                        break;
                    case R.id.bottom_night_menu:
                        drawerLayout.setBackgroundResource(R.drawable.bg1);
                        break;
                    case R.id.bottom_login_menu:
                        Intent intent = new Intent(MainActivity.this, LoginPage.class);
                        startActivity(intent);
                        break;
//                        Log.i("tag", "onNavigationItemSelected: Settings item has been selected");
                }

                return false;
            }
        });

//        --------------------------- handling welcome text--------------------
        String userName;
        welcomeText = findViewById(R.id.front_page_text);
        SharedPreferences preferences = getSharedPreferences("LoginPagePreference", MODE_PRIVATE);
        userName = preferences.getString("UserName", "Select a quiz topic");

        String userGender = preferences.getString("UserGender", "User gender loading error!!");

        welcomeText.setText("Welcome "+ userName);
        Log.i("TAG","User Gender: " +userGender);

//-------------------------- Setting all the menu options ------------------------
        historyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //      History quiz
                historyLayout.setBackgroundResource(R.drawable.on_click_background_radious);
                astroLayout.setBackgroundResource(R.drawable.background_radius_board);
                computerLayout.setBackgroundResource(R.drawable.background_radius_board);
                lawLayout.setBackgroundResource(R.drawable.background_radius_board);

                intent = new Intent(MainActivity.this, HistoryQuiz.class);
                startActivity(intent);
            }
        });
        astroLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            Astronomy Quiz
                astroLayout.setBackgroundResource(R.drawable.on_click_background_radious);
                historyLayout.setBackgroundResource(R.drawable.background_radius_board);
                computerLayout.setBackgroundResource(R.drawable.background_radius_board);
                lawLayout.setBackgroundResource(R.drawable.background_radius_board);

                intent = new Intent(MainActivity.this, AstronomyQuiz.class);
                startActivity(intent);
            }
        });
        computerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Computer quiz
                computerLayout.setBackgroundResource(R.drawable.on_click_background_radious);
                astroLayout.setBackgroundResource(R.drawable.background_radius_board);
                historyLayout.setBackgroundResource(R.drawable.background_radius_board);
                lawLayout.setBackgroundResource(R.drawable.background_radius_board);

                intent = new Intent(MainActivity.this, ComputerQuiz.class);
                startActivity(intent);
            }
        });
        lawLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Law quiz
                lawLayout.setBackgroundResource(R.drawable.on_click_background_radious);
                astroLayout.setBackgroundResource(R.drawable.background_radius_board);
                computerLayout.setBackgroundResource(R.drawable.background_radius_board);
                historyLayout.setBackgroundResource(R.drawable.background_radius_board);

                intent = new Intent(MainActivity.this, LawQuiz.class);
                startActivity(intent);
            }
        } );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu_three_dot, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_three_dot:
                Toast.makeText(this, "This option is still in process", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quiz_Thistory:
                Toast.makeText(this, "This option is still in process", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quiz_Tastronomy:
                Toast.makeText(this, "This option is still in process", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quiz_Tcomputer:
                Toast.makeText(this, "This option is still in process", Toast.LENGTH_SHORT).show();
                break;
            case R.id.quiz_Tlaw:
                Toast.makeText(this, "This option is still in process", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}