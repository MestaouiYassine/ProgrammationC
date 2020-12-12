package com.projet.programmationenc.Moduls;

import java.io.Serializable;

public class Exercice implements Serializable {
    private String exerciceID,categoryEx,contentEx,solutionEx;

    public String getExerciceID() {
        return exerciceID;
    }

    public String getCategoryEx() {
        return categoryEx;
    }

    public String getContentEx() {
        return contentEx;
    }

    public String getSolutionEx() {
        return solutionEx;
    }
}
