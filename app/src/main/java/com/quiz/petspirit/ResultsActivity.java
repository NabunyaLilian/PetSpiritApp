package com.quiz.petspirit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn;
        String quizTitle = "Congratulations !";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setTitle(quizTitle);
        btn = findViewById(R.id.back);
        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        getIncomingIntent();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToFirstPage();
            }
        });
    }

    private void returnToFirstPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void getIncomingIntent(){
        ArrayList<PetName> results;
        String resultHead;
        String resultBody;
        ImageView image;
        image = findViewById(R.id.result_image);
        Intent intent = getIntent();
        results = intent.getParcelableArrayListExtra("results");

        for (int i=0; i < results.size(); i++){
            for(int j=i+1; j < results.size(); j++){
                if(results.get(i).equals(results.get(j))){
                    switch (results.get(j)){
                        case CAT:
                           resultHead =  "You are "+ results.get(j);
                           resultBody =  "You are adorable, you like to have your own space and you're also social at your pace";
                           title.setText(resultHead);
                           content.setText(resultBody);
                           image.setImageDrawable(getResources().getDrawable(R.drawable.cat_icon));
                           break;

                        case DOG:
                            resultHead =  "You are "+ results.get(j);
                            resultBody =  "You are team player, enthusiatic and a loving person. You like to be participate in fun games too.";
                            title.setText(resultHead);
                            content.setText(resultBody);
                            image.setImageDrawable(getResources().getDrawable(R.drawable.dog_icon));
                            break;

                        case FISH:
                            resultHead =  "You are "+ results.get(j);
                            resultBody =  "You are an analytic person who takes their time to focus and do things they want";
                            title.setText(resultHead);
                            content.setText(resultBody);
                            image.setImageDrawable(getResources().getDrawable(R.drawable.fish_icon));
                            break;

                        case BUNNY:
                            resultHead =  "You are "+ results.get(j);
                            resultBody =  "You are funny, playful and have a teenage mind. Which is a great feature to possess.";
                            title.setText(resultHead);
                            content.setText(resultBody);
                            image.setImageDrawable(getResources().getDrawable(R.drawable.rabbit_icon));
                            break;
                    }
                }
            }
        }
    }

}
