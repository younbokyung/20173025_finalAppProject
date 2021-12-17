package com.example.a20173025_finalappproject;

public class Movie {
    String rnum;
    String rank;
    String rankInten;
    String rankOldAndNew;
    String movieCd;
    String movieNm;
    String openDt;
    String salesAmt;
    String salesShare;
    String salesInten;
    String salesChange;
    String salesAcc;
    String audiCnt;
    String audiInten;
    String andiChange;
    String audiAcc;
    String scrnCnt;
    String showCnt;
    String title;
    String link;
    String image;
    String subtitle;
    String pubDate;
    String director;
    String actor;
    float userRating;

    public Movie(String title, String link, String image, String pubDate, String director, String actor, String userRating){
        this.title = title;
        this.link = link;
        this.image = image;
        this.director = director;
        this.pubDate = pubDate;
        this.director = director;
        this.actor = actor;
        this.userRating = Float.parseFloat(userRating);
    }
}
