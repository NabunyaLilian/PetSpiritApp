package com.quiz.petspirit;

public class Question {
    private String question;
    public QuestionType questionType;
    public Answers[] answers;

    public Question(String question, QuestionType questionType, Answers[] answers) {
        this.question = question;
        this.questionType = questionType;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
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