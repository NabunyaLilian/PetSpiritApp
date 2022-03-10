package com.quiz.petspirit.quiz.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Answers implements Parcelable {
    private final String answer;
    private final PetName pet;


    public Answers(String answer, PetName pet) {
        this.answer = answer;
        this.pet = pet;
    }


    protected Answers(Parcel in) {
        answer = in.readString();
        pet = in.readParcelable(PetName.class.getClassLoader());
    }


    public static final Creator<Answers> CREATOR = new Creator<Answers>() {
        @Override
        public Answers createFromParcel(Parcel in) {
            return new Answers(in);
        }

        @Override
        public Answers[] newArray(int size) {
            return new Answers[size];
        }
    };

    public String getAnswer() {
        return answer;
    }

    public PetName getPet() {
        return pet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(answer);
        parcel.writeParcelable(pet, i);
    }
}

