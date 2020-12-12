package com.projet.programmationenc.Moduls;

import java.io.Serializable;

public class Quiz implements Serializable {
    private String quizID,category,question,resp1,resp2,resp3,resp4,resp;

    public String getQuizID() {
        return quizID;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getResp1() {
        return resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public String getResp4() {
        return resp4;
    }

    public String getResp() {
        return resp;
    }
}
