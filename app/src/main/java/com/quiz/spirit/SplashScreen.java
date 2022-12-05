package com.quiz.spirit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
