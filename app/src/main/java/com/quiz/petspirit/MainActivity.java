package com.quiz.petspirit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.quiz.petspirit.quiz.QuizActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
