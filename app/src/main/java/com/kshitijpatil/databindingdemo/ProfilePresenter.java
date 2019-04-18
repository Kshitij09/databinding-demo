package com.kshitijpatil.databindingdemo;

enum Popularity {
    NORMAL,
    POPULAR,
    STAR
}

public class ProfilePresenter {
    private String firstName = "John";
    private String lastName = "Doe";
    private int likes = 2;
    private Popularity popularity;


    public ProfilePresenter() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLikes() {
        return likes;
    }

    public Popularity getPopularity() {
        if (likes > 9)
            return Popularity.STAR;
        if (likes > 4)
            return Popularity.POPULAR;
        return Popularity.NORMAL;
    }

    public void incrementLikes() {
        likes++;
    }
}
