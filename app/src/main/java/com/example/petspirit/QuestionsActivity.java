package com.example.petspirit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {
    private ConstraintLayout multiple;
    private ConstraintLayout single;
    private ConstraintLayout range;
    private Button next;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private int QuestionNumber = 0;
    private ArrayList<Question> question = new ArrayList<>();
    private ProgressBar bar;
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private ArrayList<PetName> chosenAnswers = new ArrayList<>();
    private Answers[] currentAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        multiple = findViewById(R.id.multiple);
        multiple.setVisibility(View.INVISIBLE);
        single = findViewById(R.id.single);
        single.setVisibility(View.INVISIBLE);
        range = findViewById(R.id.scale);
        range.setVisibility(View.INVISIBLE);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        QuestionTitle();
        question();
        updateControls(QuestionNumber);
        clickHandler(next);
        clickHandler(button1);
        clickHandler(button2);
        clickHandler(button3);
        clickHandler(button4);

    }


    private void updateControls(int QuestionNumber){
        Question currentQuestion;
        next = findViewById(R.id.next);
        currentQuestion =  question.get(QuestionNumber);
        switch(currentQuestion.getQuestionType()) {
            case SINGLE:
                single.setVisibility(View.VISIBLE);
                next.setVisibility(View.INVISIBLE);
                setQuestion(currentQuestion);
                showProgress(30);
                setSingleControl();
                break;
            case MULTIPLE:
                multiple.setVisibility(View.VISIBLE);
                single.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                setQuestion(currentQuestion);
                showProgress(60);
                setMultipleControl();
                break;
            case RANGE:
                multiple.setVisibility(View.INVISIBLE);
                range.setVisibility(View.VISIBLE);
                setQuestion(currentQuestion);
                checkSeekBarProgress();
                bar.setProgress(90);
                break;

        }

    }

    private void question(){

        Answers[] answerOne = {
                new Answers("Steak", PetName.DOG),
                new Answers("Fish", PetName.CAT),
                new Answers("Vegetables", PetName.BUNNY),
                new Answers("legumes", PetName.FISH)
        };

        Answers[] answerTwo = {
                new Answers("Running", PetName.DOG),
                new Answers("Relaxing", PetName.CAT),
                new Answers("Playing with friends", PetName.BUNNY),
                new Answers("Adventure", PetName.FISH)
        };

        Answers[] answerThree = {
                new Answers("Yes", PetName.DOG),
                new Answers("Not really", PetName.CAT),
                new Answers("Somewhat", PetName.BUNNY),
                new Answers("No", PetName.FISH)
        };

        question.add( new Question("Which food do you like ?",QuestionType.SINGLE,answerOne));
        question.add( new Question("Which activities do you enjoy ?",QuestionType.MULTIPLE,answerTwo));
        question.add( new Question("How much do you enjoy car rides ?",QuestionType.RANGE,answerThree));
        System.out.println("Question is ");
    }

    private void QuestionTitle(){
        String questionTitle = "Question ";
        int PageNumber;
        PageNumber =  QuestionNumber +1;
        setTitle(questionTitle+PageNumber);

    }

    private void setQuestion(Question currentQuestion){
        TextView pageQuestion;
        pageQuestion = findViewById(R.id.questionTitle);
        pageQuestion.setText(currentQuestion.getQuestion());

    }

    private void clickHandler(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers[] currentAnswers = question.get(QuestionNumber).getAnswers();
                switch (view.getId()){
                    case R.id.button1:
                        chosenAnswers.add(currentAnswers[0].getPet());
                        break;
                    case R.id.button2:
                        chosenAnswers.add(currentAnswers[1].getPet());
                        break;
                    case R.id.button3:
                        chosenAnswers.add(currentAnswers[2].getPet());
                        break;
                    case R.id.button4:
                        chosenAnswers.add(currentAnswers[3].getPet());
                        break;
                }

                QuestionNumber++;
                if(QuestionNumber < 3){
                    updateControls(QuestionNumber);
                    QuestionTitle();
                }
                else{
                    launchNextActivity();
                }
            }
        });
    }

    private void launchNextActivity(){
        System.out.println("chosen answers are "+chosenAnswers);
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putParcelableArrayListExtra("results", chosenAnswers);
        startActivity(intent);

        }

    private void showProgress(int time){
        try{

            Thread.sleep(1000);
            bar = findViewById(R.id.progressBar);
            bar.setProgress(time);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setSingleControl() {
        button1.setText(question.get(0).getAnswers()[0].getAnswer());
        button2.setText(question.get(0).getAnswers()[1].getAnswer());
        button3.setText(question.get(0).getAnswers()[2].getAnswer());
        button4.setText(question.get(0).getAnswers()[3].getAnswer());
    }

    private void setMultipleControl(){
        checkBox.setText(question.get(1).getAnswers()[0].getAnswer());
        checkBox2.setText(question.get(1).getAnswers()[1].getAnswer());
        checkBox3.setText(question.get(1).getAnswers()[2].getAnswer());
        checkBox4.setText(question.get(1).getAnswers()[3].getAnswer());
    }

    public void itemChecked(View v){
        currentAnswers = question.get(1).getAnswers();
        boolean checked = ((CheckBox) v).isChecked();
        switch(v.getId()) {
            case R.id.checkBox:
                if (checked)
                    chosenAnswers.add(currentAnswers[0].getPet());

                break;
            case R.id.checkBox2:
                if (checked)
                    chosenAnswers.add(currentAnswers[1].getPet());

                break;

            case R.id.checkBox3:
                if(checked)
                    chosenAnswers.add(currentAnswers[2].getPet());

                break;

            case R.id.checkBox4:
                if(checked)
                    chosenAnswers.add(currentAnswers[3].getPet());

                break;

        }


    }

    private void checkSeekBarProgress(){

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //nothing

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //nothing

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();

                if(progress < 25){
                    chosenAnswers.add(currentAnswers[3].getPet());
                }
                else if(progress < 50){
                    chosenAnswers.add(currentAnswers[1].getPet());

                }else if(progress < 75){
                    chosenAnswers.add(currentAnswers[0].getPet());

                }else{
                    chosenAnswers.add(currentAnswers[1].getPet());
                }

            }
        });
    }

}
