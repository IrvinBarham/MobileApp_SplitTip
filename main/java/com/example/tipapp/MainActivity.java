package com.example.tipapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {

    EditText grandtotal;
    EditText numppl;
    TextView tipamt;
    TextView totalwtip;
    TextView totalper;
    TextView overage;
    private int percent = 0;
    private int numpeople = 0;
    private double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grandtotal = findViewById(R.id.input1);
        numppl = findViewById(R.id.input2);
        tipamt = findViewById(R.id.textView4);
        totalwtip = findViewById(R.id.textView5);
        totalper = findViewById(R.id.textView8);
        overage = findViewById(R.id.textView10);
    }

    public void buttonTapped(View v){
        switch (v.getId()){
            case R.id.radioButton2:
                    percent = 12;
                    break;
            case R.id.radioButton3:
                    percent = 15;
                    break;
            case R.id.radioButton4:
                    percent = 18;
                    break;
            case R.id.radioButton5:
                    percent = 20;
                    break;
            case R.id.button:
                boolean flag = false;
                if(grandtotal.getText().length() != 0) {
                    total = Double.parseDouble(grandtotal.getText().toString());
                    flag = true;
                }
                else {
                    grandtotal.requestFocus();
                    grandtotal.setError("Enter an Amount");
                    flag = false;
                }
                if(numppl.getText().length() != 0) {
                    numpeople = Integer.parseInt(numppl.getText().toString());
                    flag = true;
                }
                else {
                    numppl.requestFocus();
                    numppl.setError("Enter an Amount");
                    flag = false;
                }
                if(percent == 0) {
                    Toast.makeText(MainActivity.this, "Select Tip %", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if (flag == true) {
                    calc();
                    break;
                }
                else
                    break;
            case R.id.button2:
                    numpeople = 0;
                    total = 0.0;
                    percent = 0;
                    RadioGroup r = findViewById(R.id.radioGroup);
                    r.clearCheck();
                    grandtotal.setText("");
                    tipamt.setText("");
                    numppl.setText("");
                    totalwtip.setText("");
                    totalper.setText("");
                    overage.setText("");
                    break;
        }
    }

    private void calc() {

            double tip = total * (percent / 100.00);
            double sum = total + tip;
            double per = sum / numpeople;

            double roundtip = Math.round(tip * 100.00) /100.00;
            double roundsum = Math.round(sum * 100.00) / 100.00;
            double roundper = Math.round(per * 100.00) / 100.00;
            double over = Math.round((roundper * numpeople - sum)*100.00) / 100.00;


            tipamt.setText(String.valueOf(roundtip));
            totalwtip.setText(String.valueOf(roundsum));
            totalper.setText(String.valueOf(roundper));
            overage.setText(String.valueOf(over));
        }
}