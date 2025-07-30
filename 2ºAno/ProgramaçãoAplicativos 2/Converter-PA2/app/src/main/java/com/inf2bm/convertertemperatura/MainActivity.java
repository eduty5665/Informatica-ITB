package com.inf2bm.convertertemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    Button mButton;
    TextView mTextView;
    RadioButton mRadioButtonFah, mRadioButtonKel;

    private boolean isEmptyValue(){

        return TextUtils.isEmpty(mEditText.getText().toString());
    }

    private double calculateFahrenheit(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
        double tempF = (tempC * 9/5) + 32;
        return tempF;
    }

    private double CalculateKelvin(){
        double tempC = Double.parseDouble(mEditText.getText().toString());
        double tempK = tempC + 273.15;
        return tempK;
    }

    


    private void showResult(){
        if (isEmptyValue()){
            Toast.makeText(this,"Poxa vida! Digite algo.", Toast.LENGTH_SHORT.).show();
            return;
            //mTextView.setText("Poooooooxa vida, digita aí!");
        }
        mTextView.setText(calculateFahrenheit() + "F");
        mEditText.setText("");
    }

    public class ClickMyButton implements View.OnClickListener{
        @Override
        public void onClick(View v){
            showResult();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextInput);
        mTextView = findViewById(R.id.textViewOutput);
        mButton = findViewById(R.id.buttonCalculate);
        mButton.setOnClickListener(new ClickMyButton());
        

    }
}