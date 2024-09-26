package com.example.hw5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button showResultButton;
    private Double first, second;
    private Boolean isOperationClick;
    private String operation;
    private Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        showResultButton = findViewById(R.id.show_result_button);
        isOperationClick = false;
        operation = "0";

        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, figmaActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            first = 0.0;
            second = 0.0;
            result = 0.0;
            showResultButton.setVisibility(View.GONE);
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String text = ((MaterialButton) view).getText().toString();

        if (!text.equals("=")) {
            first = Double.valueOf(textView.getText().toString());
            operation = text;
            isOperationClick = true;
            showResultButton.setVisibility(View.GONE);
        } else {
            second = Double.valueOf(textView.getText().toString());

            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "x":
                    result = first * second;
                    break;
                case "/":
                    if (second != 0) {
                        result = first / second;
                    } else {
                        textView.setText("Error");
                        return;
                    }
                    break;
            }

            textView.setText(result.toString());
            isOperationClick = true;
            showResultButton.setVisibility(View.VISIBLE);
        }
    }
}
