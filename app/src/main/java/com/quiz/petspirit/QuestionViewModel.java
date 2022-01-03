package com.quiz.petspirit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;

public class QuestionViewModel extends ViewModel {
    ArrayList<Question> question = new ArrayList<>();
    ArrayList<PetName> chosenAnswers = new ArrayList<>();

    private MutableLiveData<PetName> pet_name;


    public MutableLiveData<PetName> getPetName() {
        if (pet_name == null) {
            pet_name = new MutableLiveData<PetName>();
        }
        return pet_name;
    }

    public void initialiseQuestions() {
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

        question.add(new Question("Which food do you like ?", QuestionType.SINGLE, answerOne));
        question.add(new Question("Which activities do you enjoy ?", QuestionType.MULTIPLE, answerTwo));
        question.add(new Question("How much do you enjoy car rides ?", QuestionType.RANGE, answerThree));
    }
}
