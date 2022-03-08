package com.quiz.petspirit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;
    Button btn;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        btn = findViewById(R.id.back);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        image = findViewById(R.id.result_image);

        String quizTitle = "Congratulations !";
        setTitle(quizTitle);

        btn.setOnClickListener(view -> returnToFirstPage());

        getIncomingIntent();
    }

    private void returnToFirstPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void getIncomingIntent() {
        ArrayList<PetName> results;
        String resultHead;
        String resultBody;
        int cat_counter=0, dog_counter=0, bunny_counter=0, fish_counter=0, bird_counter=0 ;

        Intent intent = getIntent();
        results = intent.getParcelableArrayListExtra("results");

        for(int i = 0; i < results.size(); i++){
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

        Log.d("ResultsActivity", "cat counter: " + cat_counter);
        Log.d("ResultsActivity", "dog counter: "+ dog_counter);
        Log.d("ResultsActivity", "fish counter: "+ fish_counter);
        Log.d("ResultsActivity", "bunny counter: "+ bunny_counter);
        Log.d("ResultsActivity", "bird counter: "+ bird_counter);

        if(cat_counter > dog_counter && cat_counter > fish_counter && cat_counter > bunny_counter &&
                cat_counter> bird_counter){
            resultHead = "CAT";
            resultBody = "You are adorable, you like to have your own space and you're also social at your pace";
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.cat_icon));
        }


        if(dog_counter > cat_counter && dog_counter > fish_counter && dog_counter > bunny_counter &&
                dog_counter> bird_counter){
            resultHead = "DOG";
            resultBody = "You are team player, enthusiatic and a loving person. You like to be participate in fun games too. Finding a dog as your pet will fulfill your authentic self.";
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.dog_icon));

        }


        if(fish_counter > dog_counter && fish_counter > cat_counter && fish_counter > bunny_counter &&
                fish_counter> bird_counter){
            resultHead = "FISH";
            resultBody = "You are an analytic person who takes their time to focus and do things they want";
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.fish_icon));

        }


        if(bunny_counter > dog_counter && bunny_counter > fish_counter && bunny_counter > cat_counter &&
                bunny_counter> bird_counter){
        resultHead = "BUNNY";
        resultBody = "You are funny, playful and have a teenage mind. Which is a great feature to possess.";
        title.setText(resultHead);
        content.setText(resultBody);
        image.setImageDrawable(getResources().getDrawable(R.drawable.rabbit_icon));

        }


        if(bird_counter > dog_counter && bird_counter > fish_counter && bird_counter > bunny_counter &&
                cat_counter> bird_counter){
            resultHead = "BIRD";
            resultBody = "You are funny, playful and have a teenage mind. Which is a great feature to possess.";
            title.setText(resultHead);
            content.setText(resultBody);
            image.setImageDrawable(getResources().getDrawable(R.drawable.rabbit_icon));

        }
    }

}
