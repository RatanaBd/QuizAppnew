package com.ratanlopa.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.ratanlopa.quizapp.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;
    int POINTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int correctAnswers = getIntent().getIntExtra("correct", 0);
        int totalQuestions = getIntent().getIntExtra("total", 0);

        long points = correctAnswers * POINTS;

        binding.score.setText(String.format("%d/%d", correctAnswers, totalQuestions));
        binding.earnedCoins.setText(String.valueOf(points));
        binding.score.setText("Correct Answers: " + correctAnswers);
        binding.earnedCoins.setText("Total Questions: " + totalQuestions);

        binding.shareBtn.setOnClickListener(view -> {
            // Handle sharing the results here (if needed)
        });

        binding.restartBtn.setOnClickListener(view -> {
            // Handle restarting the quiz here
            startActivity(new Intent(ResultActivity.this, MainActivity.class));
            finishAffinity();
        });
    }
}