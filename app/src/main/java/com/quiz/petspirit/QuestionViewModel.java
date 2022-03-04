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

        Answers[] answerFour = {
                new Answers("I’m longing to care for a pint-sized companion.", PetName.BUNNY),
                new Answers("I’d like a pet just like me: chirpy and quirky.", PetName.BIRD),
                new Answers("I’m looking for a BFF to share outdoor adventures and movie nights.", PetName.DOG),
                new Answers("I’m searching for the perfect roommate: fun, clean and a good listener.", PetName.CAT),
                new Answers("I’d like to come home to some low-key company after a long day.", PetName.FISH)
        };

        Answers[] answerFive = {
                new Answers("Plenty. I’m a homebody and I know a great pet sitter to back me up.", PetName.DOG),
                new Answers("Not a lot. My calendar is often packed full.", PetName.FISH),
                new Answers("I have very little time available for daily care or interaction.", PetName.BUNNY),
                new Answers("Sometimes my life gets busy, but I can find an extra hour our two each day.", PetName.BIRD),
                new Answers("Tons! I have a flexible schedule and plan to hire help as needed.", PetName.CAT)
        };

        Answers[] answerSix = {
                new Answers("Cozy, with an abundance of sunny windowsills.", PetName.DOG),
                new Answers("t’s perfect for me, and I’m positive I don’t want a pet roaming around.", PetName.CAT),
                new Answers("I have plenty of space in my home, plus a backyard.", PetName.BUNNY),
                new Answers("Pretty fly, with plenty of perches.", PetName.FISH),
                new Answers("It’s perfect for me, but I’m not so sure I want a pet roaming around…", PetName.FISH)
        };

        Answers[] answerSeven = {
                new Answers("As much as it takes. I plan to work with a trainer and am looking forward to learning along with my pet.", PetName.DOG),
                new Answers("I’m not against training, but I wasn’t planning on it.", PetName.CAT),
                new Answers("A little bit. Tricks sound especially fun!", PetName.BUNNY),
                new Answers("A good amount. I’m prepared for the basics, and anything else that might benefit my pet.", PetName.FISH),
                new Answers("I’d prefer a pet that doesn’t require any training.", PetName.FISH)
        };

        Answers[] answerEight = {
                new Answers("After the initial costs for a habitat and supplies, I’d like to spend very little.", PetName.FISH),
                new Answers("Generous. In addition to budgeting for the basics, I plan to have an emergency fund set aside.", PetName.DOG),
                new Answers("Basic. I can afford start-up supplies and inexpensive recurring costs.", PetName.BIRD),
                new Answers("Healthy. I can afford both routine and unexpected costs, if necessary.", PetName.CAT),
                new Answers("Pretty good, but I’d like to avoid any major expenses.", PetName.BUNNY)
        };

        Answers[] answerNine = {
                new Answers("As long as most of the mess remains in a cage, I don’t mind.", PetName.BIRD),
                new Answers("I’ve been called a neat freak, and I’m looking for a similar pet.", PetName.CAT),
                new Answers("Habitat maintenance is fine, but anything beyond that is a deal breaker.", PetName.FISH),
                new Answers("The occasional spill or shedding won’t bother me.", PetName.DOG),
                new Answers("I’m OK with muddy paws and the occasional chewed up cushion.", PetName.BUNNY)
        };

        Answers[] answerTen = {
                new Answers("“Paulie” made my spirits soar.", PetName.DOG),
                new Answers("“Ratatouille,” oui oui!", PetName.CAT),
                new Answers("“Air Bud” for the win!", PetName.BIRD),
                new Answers("Thackery Binx put the magic in “Hocus Pocus.”", PetName.BUNNY),
                new Answers("“Finding Nemo” swam its way into my heart.", PetName.FISH)
        };

        question.add(new Question("Which food do you like ?", QuestionType.SINGLE, answerOne));
        question.add(new Question("Which activities do you enjoy ?", QuestionType.MULTIPLE, answerTwo));
        question.add(new Question("How much do you enjoy car rides ?", QuestionType.RANGE, answerThree));
        question.add(new Question("Why do you want a pet?", QuestionType.SINGLE, answerFour));
        question.add(new Question("How much time are you able to devote to your new friend?", QuestionType.SINGLE, answerFive));
        question.add(new Question("What’s your home like?", QuestionType.SINGLE, answerSix));
        question.add(new Question("How much training are you willing to do?", QuestionType.SINGLE, answerSeven));
        question.add(new Question("What does your pet budget look like??", QuestionType.SINGLE, answerEight));
        question.add(new Question("How much cleaning are you willing to do?", QuestionType.SINGLE, answerNine));
        question.add(new Question("What is your favorite animal movie?", QuestionType.SINGLE, answerTen));
    }
}
