package com.application.sport.football;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button scoreReset;
    Button NKoreaAddScore;
    Button brazilAddScore;
    TextView brazilScoreView;
    TextView NKoreaScoreView;

    Integer brazilScore = 0;
    Integer NKoreaScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreReset = (Button) findViewById(R.id.scoreReset);
        NKoreaAddScore = findViewById(R.id.NKoreaAddScore);
        brazilAddScore = findViewById(R.id.brazilAddScore);

        brazilScoreView = findViewById(R.id.brazilScore);
        NKoreaScoreView = findViewById(R.id.NKoreaScore);


        View.OnClickListener oScoreReset = v -> {
            brazilScoreView.setText("0");
            NKoreaScoreView.setText("0");
            NKoreaScore = 0;
            brazilScore = 0;
        };

        View.OnClickListener oNKoreaAddScore = v -> {
            NKoreaScore++;
            NKoreaScoreView.setText(NKoreaScore.toString());
        };

        View.OnClickListener oBrazilAddScore = v -> {
            brazilScore++;
            brazilScoreView.setText(brazilScore.toString());

        };

        scoreReset.setOnClickListener(oScoreReset);
        NKoreaAddScore.setOnClickListener(oNKoreaAddScore);
        brazilAddScore.setOnClickListener(oBrazilAddScore);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("brazilScore",brazilScore);
        outState.putInt("NKoreaScore",NKoreaScore);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        brazilScore = savedInstanceState.getInt("brazilScore");
        NKoreaScore = savedInstanceState.getInt("NKoreaScore");
        NKoreaScoreView.setText(NKoreaScore.toString());
        brazilScoreView.setText(brazilScore.toString());
    }
}