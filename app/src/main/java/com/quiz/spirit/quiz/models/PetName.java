package com.quiz.spirit.quiz.models;

import android.os.Parcel;
import android.os.Parcelable;

public enum PetName implements Parcelable {
    CAT,
    DOG,
    FISH,
    BIRD,
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
