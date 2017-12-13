package com.devvindan.pomodoro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class PomodoroMenu extends AppCompatActivity implements View.OnClickListener {

    Button timerButton, infoButton, settingsButton, quitButton;
    ImageView logo;

    public static int WORK_TIME = 25;
    public static int LONG_BREAK = 20;
    public static int SHORT_BREAK = 5;


    // Adds getters and setters

    public static int getWORK_TIME(){
        return WORK_TIME;
    }

    public static void setWORK_TIME(int time){
        WORK_TIME = time;
    }

    public static int getLONG_BREAK(){
        return LONG_BREAK;
    }

    public static void setLONG_BREAK(int time){
        LONG_BREAK = time;
    }

    public static int getSHORT_BREAK(){
        return SHORT_BREAK;
    }

    public static void setSHORT_BREAK(int time){
        SHORT_BREAK = time;
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.timerButton:
                intent = new Intent(this, PomodoroMain.class);
                startActivity(intent);
                break;
            case R.id.infoButton:
                intent = new Intent(this, PomodoroInfo.class);
                startActivity(intent);
                break;
            case R.id.settingsButton:
                intent = new Intent(this, PomodoroSettings.class);
                startActivity(intent);
                break;
            case R.id.quitButton:
                finish();
                break;
            case R.id.logo:
                Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
                logo.startAnimation(anim);
                break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_menu);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim);

        // Finds buttons

        timerButton = (Button) findViewById(R.id.timerButton);
        infoButton = (Button) findViewById(R.id.infoButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        quitButton = (Button) findViewById(R.id.quitButton);

        // Sets buttons listeners

        timerButton.setOnClickListener(this);
        infoButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);

        logo = (ImageView) findViewById(R.id.logo);
        logo.startAnimation(anim);
        logo.setOnClickListener(this);


    }
}
