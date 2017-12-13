package com.devvindan.pomodoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PomodoroInfo extends AppCompatActivity implements View.OnClickListener{

    Button backButton;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_info);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

    }
}
