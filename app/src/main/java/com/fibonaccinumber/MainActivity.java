package com.fibonaccinumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.et_input_n);
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        final String inputStr = s.toString();
        final int n;

        try {
             n = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return ;
        }

        final FastFibonacci fibonacci = new FastFibonacci(n);
        final BigInteger result = fibonacci.calc(n);

        EditText editText = findViewById(R.id.et_result);
        editText.setText(String.valueOf(result));
    }
}
