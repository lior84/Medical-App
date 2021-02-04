package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    EditText height, weight;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI(){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){
            float heighValue = Float.parseFloat(heightStr) / 100;
            float weighValue = Float.parseFloat(weightStr);

            float bmi = weighValue / (heighValue * heighValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi){
        String bmiLabel = "";

        if(Float.compare(bmi, 15f) <= 0){
            bmiLabel = "Very severely underweight";
        }else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <=0){
            bmiLabel = "severely underweight";
        }else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <=0){
            bmiLabel = "underweight";
        }else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <=0){
            bmiLabel = "normal";
        }else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <=0){
            bmiLabel = "overweight";
        }else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <=0){
            bmiLabel = "obese class I";
        }else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <=0){
            bmiLabel = "obese class II";
        }else{
            bmiLabel = "obese class III";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }

}
