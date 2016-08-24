package com.example.yt_home.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        // 2016.08.24 [修正] EditTextの入力を数値に制限
        mEditText1.setInputType( InputType.TYPE_CLASS_NUMBER);
        mEditText2.setInputType( InputType.TYPE_CLASS_NUMBER);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int calcId = 0;  // 演算種別
        double val1;
        double val2;

        if (v.getId() == R.id.button1) {
            calcId = 0;
        } else if (v.getId() == R.id.button2) {
            calcId = 1;
        } else if (v.getId() == R.id.button3) {
            calcId = 2;
        } else if (v.getId() == R.id.button4) {
            calcId = 3;
        }

        Log.d("ANDROID", "--------------------------"); // デバッグ用に追加する

        // 2016.08.24 [修正] 空文字列チェック
        if(mEditText1.getText().toString().equals(""))
        {
            Log.d("ANDROID", "mEditText1は空文字列"); // デバッグ用に追加する
            return;
        }
        if(mEditText2.getText().toString().equals(""))
        {
            Log.d("ANDROID", "mEditText2は空文字列"); // デバッグ用に追加する
            return;
        }
        Log.d("ANDROID", "mEditText1,2は空文字列ではない"); // デバッグ用に追加する

        val1 = Double.parseDouble(mEditText1.getText().toString());
        val2 = Double.parseDouble(mEditText2.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", val1);
        intent.putExtra("VALUE2", val2);
        intent.putExtra("VALUE3", calcId);
        startActivity(intent);
    }
}
