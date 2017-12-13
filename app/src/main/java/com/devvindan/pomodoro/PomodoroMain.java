package com.devvindan.pomodoro;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PomodoroMain extends AppCompatActivity implements View.OnClickListener{

    Button startWorkButton, stopButton, startShortButton, startLongButton;
    ImageView pomodoro1, pomodoro2, pomodoro3, pomodoro4;
    CountDownTimer cdTimer = null;
    TextView time, phase;
    MediaPlayer sound;
    public int pomodorCount = 0;
    public long workTime, shortTime, longTime;
    public boolean finished;



    public void setWorkTimer(long duration){


        pomodorCount %= 4;

        if (pomodorCount == 0){
            pomodoro1.setAlpha((float) 0.3);
            pomodoro2.setAlpha((float) 0.3);
            pomodoro3.setAlpha((float) 0.3);
            pomodoro4.setAlpha((float) 0.3);
        }

        cdTimer = new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long timeUntilFinish) {
                time.setText(String.format("%02d", ((timeUntilFinish / 60000) % 100)) + ":" + String.format("%02d", ((timeUntilFinish / 1000) % 60)));
            }

            @Override
            public void onFinish() {
                sound.start();
                time.setText("00:00");
                phase.setText("");
                pomodorCount++;

                switch (pomodorCount){

                    case 1:
                        pomodoro1.setAlpha((float) 1.0);
                        break;
                    case 2:
                        pomodoro2.setAlpha((float) 1.0);
                        break;
                    case 3:
                        pomodoro3.setAlpha((float) 1.0);
                        break;
                    case 4:
                        pomodoro4.setAlpha((float) 1.0);
                        break;

                }

            }
        };
        cdTimer.start();
    }

    public void setBreakTimer(long duration){

        cdTimer = new CountDownTimer(duration, 1000) {

            @Override
            public void onTick(long timeUntilFinish) {
                time.setText(String.format("%02d", ((timeUntilFinish / 60000) % 100)) + ":" + String.format("%02d", ((timeUntilFinish / 1000) % 60)));
            }

            @Override
            public void onFinish() {

                sound.start();
                time.setText("00:00");
                phase.setText("");

            }
        };
        cdTimer.start();
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.startWorkButton:

                if (cdTimer != null) { cdTimer.cancel(); };
                phase.setText(R.string.work_label);
                setWorkTimer(workTime);

                break;

            case R.id.stopButton:

                if (cdTimer != null) { cdTimer.cancel(); };

                pomodoro1.setAlpha((float) 0.3);
                pomodoro2.setAlpha((float) 0.3);
                pomodoro3.setAlpha((float) 0.3);
                pomodoro4.setAlpha((float) 0.3);

                time.setText("00:00");
                phase.setText("");

                break;

            case R.id.startShortButton:

                if (cdTimer != null) { cdTimer.cancel(); };

                phase.setText(R.string.short_label);
                setBreakTimer(shortTime);
                break;

            case R.id.startLongButton:

                if (cdTimer != null) { cdTimer.cancel(); };

                phase.setText(R.string.long_label);
                setBreakTimer(longTime);

                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_main);


        workTime = PomodoroMenu.getWORK_TIME() * 60 * 1000;
        shortTime = PomodoroMenu.getSHORT_BREAK() * 60 * 1000;
        longTime = PomodoroMenu.getLONG_BREAK() * 60 * 1000;
        sound = MediaPlayer.create(this, R.raw.bell);

        // Finds components

        startWorkButton = (Button) findViewById(R.id.startWorkButton);
        startShortButton = (Button) findViewById(R.id.startShortButton);
        startLongButton = (Button) findViewById(R.id.startLongButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        pomodoro1 = (ImageView) findViewById(R.id.pomodoro1);
        pomodoro2 = (ImageView) findViewById(R.id.pomodoro2);
        pomodoro3 = (ImageView) findViewById(R.id.pomodoro3);
        pomodoro4 = (ImageView) findViewById(R.id.pomodoro4);

        time = (TextView) findViewById(R.id.timeView);
        phase = (TextView) findViewById(R.id.phaseView);
        phase.setText("");

        // Sets OnClick listeners

        startWorkButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        startShortButton.setOnClickListener(this);
        startLongButton.setOnClickListener(this);




    }



}
