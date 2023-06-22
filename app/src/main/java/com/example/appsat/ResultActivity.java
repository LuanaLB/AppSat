package com.example.appsat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView cityTextView;
    private TextView satisfactionTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        cityTextView = findViewById(R.id.cityTextView);
        satisfactionTextView = findViewById(R.id.satisfactionTextView);

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        int satisfaction = intent.getIntExtra("satisfaction", 0);

        cityTextView.setText("Cidade: " + city);
        satisfactionTextView.setText("Nível de satisfação em relação a cidade: " + satisfaction);
    }

    public void back(View view) {
        finish();
    }
}