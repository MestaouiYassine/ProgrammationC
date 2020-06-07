package com.projet.programmationenc;

import android.widget.ImageButton;

public class CardViewExercices {
    private int imageResource;
    private String mText,mQuiz1,mQuiz2,mEx1,mEx2;
    private boolean selected;

    public CardViewExercices(int imageResource, String mText, String mQuiz1,String mQuiz2, String mEx1, String mEx2, boolean selected) {
        this.imageResource = imageResource;
        this.mText = mText;
        this.mQuiz1 = mQuiz1;
        this.mQuiz2 = mQuiz2;
        this.mEx1 = mEx1;
        this.mEx2 = mEx2;
        this.selected = selected;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getmText() {
        return mText;
    }

    public String getmQuiz1() {
        return mQuiz1;
    }

    public String getmQuiz2() {
        return mQuiz2;
    }

    public String getmEx1() {
        return mEx1;
    }

    public String getmEx2() {
        return mEx2;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
