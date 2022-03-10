package com.quiz.petspirit.quiz.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.quiz.petspirit.quiz.models.Answers;
import com.quiz.petspirit.quiz.models.PetName;
import com.quiz.petspirit.quiz.models.Question;
import com.quiz.petspirit.quiz.models.QuestionType;

import java.util.ArrayList;

public class QuizViewModel extends ViewModel {
    public ArrayList<Question> question = new ArrayList<>();
    public ArrayList<PetName> chosenAnswers = new ArrayList<>();

    private MutableLiveData<PetName> pet_name;


    public MutableLiveData<PetName> getPetName() {
        if (pet_name == null) {
            pet_name = new MutableLiveData<>();
        }
        return pet_name;
    }

    public void initialiseQuestions() {

        Answers[] answerOne = {
                new Answers("I’m longing to care for a pint-sized companion.", PetName.BUNNY),
                new Answers("I’d like a pet just like me: chirpy and quirky.", PetName.BIRD),
                new Answers("I’m looking for a BFF to share outdoor adventures and movie nights.", PetName.DOG),
                new Answers("I’m searching for the perfect roommate: fun, clean and a good listener.", PetName.CAT),
                new Answers("I’d like to come home to some low-key company after a long day.", PetName.FISH)
        };
        question.add(new Question("Why do you want a pet?", QuestionType.SINGLE, answerOne));


        Answers[] answerTwo = {
                new Answers("Plenty. I’m a homebody and I know a great pet sitter to back me up.", PetName.CAT),
                new Answers("Not a lot. My calendar is often packed full.", PetName.FISH),
                new Answers("I have very little time available for daily care or interaction.", PetName.BUNNY),
                new Answers("Sometimes my life gets busy, but I can find an extra hour our two each day.", PetName.BIRD),
                new Answers("Tons! I have a flexible schedule and plan to hire help as needed.", PetName.DOG)
        };
        question.add(new Question("How much time are you able to devote to your new friend?", QuestionType.SINGLE, answerTwo));


        Answers[] answerThree = {
                new Answers("Cozy, with an abundance of sunny windowsills.", PetName.CAT),
                new Answers("t’s perfect for me, and I’m positive I don’t want a pet roaming around.", PetName.FISH),
                new Answers("I have plenty of space in my home, plus a backyard.", PetName.DOG),
                new Answers("Pretty fly, with plenty of perches.", PetName.BIRD),
                new Answers("It’s perfect for me, but I’m not so sure I want a pet roaming around…", PetName.BUNNY)
        };
        question.add(new Question("What’s your home like?", QuestionType.SINGLE, answerThree));


        Answers[] answerFour = {
                new Answers("As much as it takes. I plan to work with a trainer and am looking forward to learning along with my pet.", PetName.DOG),
                new Answers("I’m not against training, but I wasn’t planning on it.", PetName.BUNNY),
                new Answers("A little bit. Tricks sound especially fun!", PetName.BIRD),
                new Answers("A good amount. I’m prepared for the basics, and anything else that might benefit my pet.", PetName.CAT),
                new Answers("I’d prefer a pet that doesn’t require any training.", PetName.FISH)
        };
        question.add(new Question("How much training are you willing to do?", QuestionType.SINGLE, answerFour));


        Answers[] answerFive = {
                new Answers("After the initial costs for a habitat and supplies, I’d like to spend very little.", PetName.FISH),
                new Answers("Generous. In addition to budgeting for the basics, I plan to have an emergency fund set aside.", PetName.DOG),
                new Answers("Basic. I can afford start-up supplies and inexpensive recurring costs.", PetName.BIRD),
                new Answers("Healthy. I can afford both routine and unexpected costs, if necessary.", PetName.CAT),
                new Answers("Pretty good, but I’d like to avoid any major expenses.", PetName.BUNNY)
        };
        question.add(new Question("What does your pet budget look like??", QuestionType.SINGLE, answerFive));


        Answers[] answerSix = {
                new Answers("As long as most of the mess remains in a cage, I don’t mind.", PetName.BIRD),
                new Answers("I’ve been called a neat freak, and I’m looking for a similar pet.", PetName.CAT),
                new Answers("Habitat maintenance is fine, but anything beyond that is a deal breaker.", PetName.FISH),
                new Answers("The occasional spill or shedding won’t bother me.", PetName.DOG),
                new Answers("I’m OK with muddy paws and the occasional chewed up cushion.", PetName.BUNNY)
        };
        question.add(new Question("How much cleaning are you willing to do?", QuestionType.SINGLE, answerSix));


        Answers[] answerSeven = {
                new Answers("“Rio” a macaw named Blu.", PetName.BIRD),
                new Answers("“Ratatouille,” oui oui!", PetName.BUNNY),
                new Answers("“Secret life of pets” for the win!", PetName.DOG),
                new Answers("“Puss in boots.” Jack and Jill", PetName.CAT),
                new Answers("“Finding Nemo” swam its way into my heart.", PetName.FISH)
        };
        question.add(new Question("What is your favorite animated movie?", QuestionType.SINGLE, answerSeven));
    }
}
