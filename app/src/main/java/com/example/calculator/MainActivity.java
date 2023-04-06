package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        working = findViewById(R.id.calcWork);
        working.setShowSoftInputOnFocus(false);
        working.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.calcWork).equals(working.getText().toString())) {
                    working.setText("");
                }
            }
        });
    }

    private void newWorking(String stringToAdd) {
        String oldString = working.getText().toString();
        int cursorPos = working.getSelectionStart();
        String leftString = oldString.substring(0, cursorPos);
        String rightString = oldString.substring(cursorPos);
        if (getString(R.string.calcWork).equals(working.getText().toString())) {
            working.setText(stringToAdd);
            working.setSelection(cursorPos + 1);
        }
        else {
            working.setText(String.format("%s%s%s", leftString, stringToAdd, rightString));
            working.setSelection(cursorPos + 1);
        }
    }

    public void oneOnClick(View view) {
        newWorking("1");
    }

    public void twoOnClick(View view) {
        newWorking("2");
    }

    public void threeOnClick(View view) {
        newWorking("3");
    }

    public void fourOnClick(View view) {
        newWorking("4");
    }

    public void fiveOnClick(View view) {
        newWorking("5");
    }

    public void sixOnClick(View view) {
        newWorking("6");
    }

    public void sevenOnClick(View view) {
        newWorking("7");
    }

    public void eightOnClick(View view) {
        newWorking("8");
    }

    public void nineOnClick(View view) {
        newWorking("9");
    }

    public void zeroOnClick(View view) {
        newWorking("0");
    }

    public void equalOnClick(View view) {
        String Expression = working.getText().toString();
        Expression = Expression.replaceAll("÷", "/");
        Expression = Expression.replaceAll("×", "*");

        Expression exp = new Expression(Expression);
        String result = String.valueOf(exp.calculate());
        working.setText(result);
        working.setSelection(result.length());
    }

    public void clearOnClick(View view) {
        working.setText("");
    }

    public void divideOnClick(View view) {
        newWorking("/");
    }

    public void timesOnClick(View view) {
        newWorking("*");
    }

    public void addOnClick(View view) {
        newWorking("+");
    }

    public void subOnClick(View view) {
        newWorking("-");
    }
}