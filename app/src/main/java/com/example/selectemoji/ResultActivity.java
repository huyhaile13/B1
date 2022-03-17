package com.example.selectemoji;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_result);

        processResult();

        Button tryAgain = findViewById(R.id.tryAgain);
        tryAgain.setOnClickListener(view -> finish());
    }

    private void processResult() {
        Intent intent = getIntent();
        boolean isWin = intent.getBooleanExtra("isWin", false);
        long timeCount = intent.getLongExtra("timeCount", 0);

        TextView resultOfGame = findViewById(R.id.resultOfGame);
        int resultTextId = isWin ? R.string.result_win : R.string.result_lose;
        resultOfGame.setText(getResources().getString(resultTextId));
        int resultColorId = isWin ? R.color.green : R.color.red;
        resultOfGame.setTextColor(getResources().getColor(resultColorId));

        TextView description = findViewById(R.id.description);
        int descriptionId = isWin ? R.string.description_win : R.string.description_lose;
        String desc = getResources().getString(descriptionId) + (isWin ? ": " + timeCount : "");
        description.setText(desc);
    }
}
