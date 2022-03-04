package com.quiz.petspirit;

public class Question {
    private final String title;
    public QuestionType questionType;
    public Answers[] answers;

    public Question(String question, QuestionType questionType, Answers[] answers) {
        this.title = question;
        this.questionType = questionType;
        this.answers = answers;
    }

    public String getTitle() {
        return title;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Answers[] getAnswers() {
        return answers;
    }
}

enum QuestionType{
    MULTIPLE,
    SINGLE,
    RANGE
}