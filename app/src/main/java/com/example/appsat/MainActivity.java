package com.example.appsat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView cityAutoCompleteTextView;
    private SeekBar satisfactionSeekBar;
    private ImageView satisfactionImageView;

    private String[] cities = {"Palmas", "Brejinho de nazaré", "Cariri", "Porto Nacional", "Ponte alta o Tocantins", "Palmeirópolis"};

    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityAutoCompleteTextView = findViewById(R.id.cityAutoCompleteTextView);
        satisfactionSeekBar = findViewById(R.id.satisfactionSeekBar);
        satisfactionImageView = findViewById(R.id.satisfactionImageView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, cities);
        cityAutoCompleteTextView.setAdapter(adapter);

        satisfactionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        satisfactionImageView.setImageResource(R.drawable.satis0);
                        break;
                    case 1:
                        satisfactionImageView.setImageResource(R.drawable.satis1);
                        break;
                    case 2:
                        satisfactionImageView.setImageResource(R.drawable.satis2);
                        break;
                    case 3:
                        satisfactionImageView.setImageResource(R.drawable.satis3);
                        break;
                    case 4:
                        satisfactionImageView.setImageResource(R.drawable.satis4);
                        break;
                }

                Button buttonSubmit = findViewById(R.id.button_submit);
                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        submit(view);
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void submit(View view) {
                String city = cityAutoCompleteTextView.getText().toString();
                int satisfaction = satisfactionSeekBar.getProgress();

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("city", city);
                intent.putExtra("satisfaction", satisfaction);
                startActivity(intent);
            }
        });
    }
}