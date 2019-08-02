package com.example.petspirit;

import android.os.Parcel;
import android.os.Parcelable;

public class Answers implements Parcelable{
    private String answer;
    private PetName pet;


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

enum PetName implements Parcelable {
    CAT,
    DOG,
    FISH,
    BUNNY;


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ordinal());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PetName> CREATOR = new Creator<PetName>() {
        @Override
        public PetName createFromParcel(Parcel in) {
            return PetName.values()[in.readInt()];
        }

        @Override
        public PetName[] newArray(int size) {
            return new PetName[size];
        }
    };
}
