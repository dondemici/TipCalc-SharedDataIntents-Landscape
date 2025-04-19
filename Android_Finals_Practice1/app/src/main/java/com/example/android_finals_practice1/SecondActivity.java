package com.example.android_finals_practice1;

import static com.example.android_finals_practice1.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String mPayment = intent.getStringExtra("mPayment");
        textView.setText("Monthly Payment of "+name+": "+mPayment);
    }
}
