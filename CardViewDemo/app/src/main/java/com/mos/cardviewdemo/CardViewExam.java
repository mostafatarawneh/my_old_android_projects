package com.mos.cardviewdemo;

public class CardViewExam {
   private int img ;
   private String body;

    public CardViewExam(int img, String body) {
        this.img = img;
        this.body = body;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
