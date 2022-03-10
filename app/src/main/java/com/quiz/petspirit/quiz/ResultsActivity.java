package com.quiz.petspirit.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quiz.petspirit.MainActivity;
import com.quiz.petspirit.R;
import com.quiz.petspirit.quiz.models.PetName;

import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;
    Button btn;
    ImageView image;
    int cat_counter = 0, dog_counter = 0, bunny_counter = 0, fish_counter = 0, bird_counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        btn = findViewById(R.id.back);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        image = findViewById(R.id.result_image);

        String quizTitle = "Results!";
        setTitle(quizTitle);

        btn.setOnClickListener(view -> returnToFirstPage());

        getIncomingIntent();
        updateUI();
    }

    private void returnToFirstPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private void getIncomingIntent() {
        ArrayList<PetName> results;

        Intent intent = getIntent();
        results = intent.getParcelableArrayListExtra("results");

        for (int i = 0; i < results.size(); i++) {
            switch (results.get(i)) {
                case CAT:
                    cat_counter++;
                    break;

                case DOG:
                    dog_counter++;
                    break;

                case FISH:
                    fish_counter++;
                    break;

                case BUNNY:
                    bunny_counter++;
                    break;

                case BIRD:
                    bird_counter++;
                    break;
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void updateUI() {
        String resultHead;
        String resultBody;

        // update UI based on results

        if (cat_counter > dog_counter && cat_counter > fish_counter && cat_counter > bunny_counter &&
                cat_counter > bird_counter) {
            resultHead = getString(R.string.cat);
            resultBody = getString(R.string.cat_result);
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.cat_img));
        }


        if (dog_counter > cat_counter && dog_counter > fish_counter && dog_counter > bunny_counter &&
                dog_counter > bird_counter) {
            resultHead = getString(R.string.dog);
            resultBody = getString(R.string.dog_result);
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.dog_img));

        }


        if (fish_counter > dog_counter && fish_counter > cat_counter && fish_counter > bunny_counter &&
                fish_counter > bird_counter) {
            resultHead = getString(R.string.fish);
            resultBody = getString(R.string.fish_result);
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.fish_img));

        }


        if (bunny_counter > dog_counter && bunny_counter > fish_counter && bunny_counter > cat_counter &&
                bunny_counter > bird_counter) {
            resultHead = getString(R.string.bunny);
            resultBody = getString(R.string.bunny_result);
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.bunny_img));

        }


        if (bird_counter > dog_counter && bird_counter > fish_counter && bird_counter > bunny_counter &&
                bird_counter > cat_counter) {
            resultHead = getString(R.string.bird);
            resultBody = getString(R.string.bird_result);
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.bird_img));

        }
    }

}
