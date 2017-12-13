package com.devvindan.pomodoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PomodoroSettings extends AppCompatActivity implements View.OnClickListener {

    Button backButton;
    EditText workEdit, shortBreakEdit, longBreakEdit;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        PomodoroMenu.setWORK_TIME(Integer.parseInt(workEdit.getText().toString()));
        PomodoroMenu.setSHORT_BREAK(Integer.parseInt(shortBreakEdit.getText().toString()));
        PomodoroMenu.setLONG_BREAK(Integer.parseInt(longBreakEdit.getText().toString()));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_settings);

        // Finds buttons and edits

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

        workEdit = (EditText) findViewById(R.id.workEdit);
        shortBreakEdit = (EditText) findViewById(R.id.shortBreakEdit);
        longBreakEdit = (EditText) findViewById(R.id.longBreakEdit);

        // Loads settings

        workEdit.setText(String.valueOf(PomodoroMenu.getWORK_TIME()));
        shortBreakEdit.setText(String.valueOf(PomodoroMenu.getSHORT_BREAK()));
        longBreakEdit.setText(String.valueOf(PomodoroMenu.getLONG_BREAK()));

    }
}
