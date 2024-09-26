package com.example.hw5;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class figmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figma);


        Double result = getIntent().getDoubleExtra("result", 0.0);

        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(String.valueOf(result));
    }
}

