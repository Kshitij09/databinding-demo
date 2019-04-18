package com.kshitijpatil.databindingdemo.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kshitijpatil.databindingdemo.models.User;

public class ProfilePresenter {
    private MutableLiveData<User> user;
    private Popularity popularity;


    public ProfilePresenter() {
        user = new MutableLiveData<>();
        user.setValue(new User("John", "Doe"));
    }

    public Popularity getPopularity() {
        int likes = user.getValue().getLikes();
        if (likes > 9)
            return Popularity.STAR;
        if (likes > 4)
            return Popularity.POPULAR;
        return Popularity.NORMAL;
    }

    public void incrementLikes() {
        user.setValue(user.getValue().addLike());
    }

    public LiveData<User> getUser() {
        return user;
    }

    public enum Popularity {
        NORMAL,
        POPULAR,
        STAR
    }
}
