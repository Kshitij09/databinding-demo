package com.kshitijpatil.databindingdemo.models;

public class User {
    String firstName;
    String lastName;
    int likes;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes =
                likes;
    }

    public User addLike() {
        this.likes++;
        return this;
    }
}
