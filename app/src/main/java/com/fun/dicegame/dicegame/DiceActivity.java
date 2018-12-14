package com.fun.dicegame.dicegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

public class DiceActivity extends Activity implements View.OnClickListener {
    private TextView textResult;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = findViewById(R.id.textTitle);
        textTitle.setText(String.format(getResources().getString(R.string.textTitle_text), max));

        textResult = findViewById(R.id.textResult);
        textResult.setText("");

        Button buttonRoll = findViewById(R.id.buttonRoll);
        buttonRoll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int result = random.nextInt(max) + 1;
        textResult.setText(String.valueOf(result));
    }
}
