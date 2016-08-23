package com.example.yt_home.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int calcId = intent.getIntExtra("VALUE3", 0);
        TextView textView = (TextView) findViewById(R.id.textView);

        double ans = 0;
        if (calcId == 0) {
            ans = value1 + value2;
        } else if (calcId == 1) {
            ans = value1 - value2;
        } else if (calcId == 2) {
            ans = value1 * value2;
        } else if (calcId == 3) {
            ans = value1 / value2;
        }

        textView.setText("Answer: " + String.valueOf(ans));
    }
}
