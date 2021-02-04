package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    private Button b3;
    private Button b6;
    private Button b8;
    private Button b7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();

            }
        });

        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();

            }
        });

        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();

            }
        });

        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();

            }
        });

    }

    public void openActivity3()
    {
        Intent in3 = new Intent(this, Alarm.class);
        startActivity(in3);
    }

    public void openActivity6()
    {
        Intent in6 = new Intent(this, contUs.class);
        startActivity(in6);
    }

    public void openActivity7()
    {
        Intent in7 = new Intent(this, BarcodPay.class);
        startActivity(in7);
    }

    public void openActivity8()
    {
        Intent in8 = new Intent(this, Calculator.class);
        startActivity(in8);
    }

}
