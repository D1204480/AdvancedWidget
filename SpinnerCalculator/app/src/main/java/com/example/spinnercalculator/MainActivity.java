package com.example.spinnercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView

        .OnItemSelectedListener {

    private double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 給初始值
        EditText et_num1 = (EditText) findViewById(R.id.num1);
        et_num1.setText("0");

        EditText et_num2 = (EditText) findViewById(R.id.num2);
        et_num2.setText("0");

        // 註冊監聽
        Spinner operation = (Spinner) findViewById(R.id.spinner);
        operation.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // 取得數字
        EditText et_num1 = (EditText) findViewById(R.id.num1);
        num1 = Double.parseDouble(String.valueOf(et_num1.getText()));

        EditText et_num2 = (EditText) findViewById(R.id.num2);
        num2 = Double.parseDouble(String.valueOf(et_num2.getText()));

        // 取得作方法的字串
        String[] operations = getResources().getStringArray(R.array.operation);
        double answer = 0.0;

        switch (operations[i]) {
            case "+":
                answer = num1 + num2;
                break;

            case "-":
                answer = num1 - num2;
                break;

            case "*":
                answer = num1 * num2;
                break;

            case "/":
                answer = num1 / num2;
                break;

        }

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(String.valueOf(answer));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}