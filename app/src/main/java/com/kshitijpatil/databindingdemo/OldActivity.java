package com.kshitijpatil.databindingdemo;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;

public class OldActivity extends AppCompatActivity {
    TextView txtFirstName, txtLastName, txtLike;
    Button btnLike;
    ImageView imgPopularity;
    ProgressBar progressLikes;

    ProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old);

        txtFirstName = findViewById(R.id.txt_name);
        txtLastName = findViewById(R.id.txt_lastname);
        txtLike = findViewById(R.id.txt_likes);
        btnLike = findViewById(R.id.btn_like);
        imgPopularity = findViewById(R.id.img_popularity);
        progressLikes = findViewById(R.id.progress_like);


        presenter = new ProfilePresenter();
        updateName();
        updateLikes();

        btnLike.setOnClickListener((View v) -> {
            presenter.incrementLikes();
            updateLikes();
        });
    }

    private void updateLikes() {

        txtLike.setText(String.valueOf(presenter.getLikes()));
        //Math.min((presenter.getLikes() * 10), 100)
        progressLikes.setProgress(presenter.getLikes() * 10);

        int color = getAssociatedColor(presenter.getPopularity());

        ImageViewCompat.setImageTintList(imgPopularity, ColorStateList.valueOf(color));

        imgPopularity.setImageDrawable(getDrawablePopularity(presenter.getPopularity()));
    }

    private void updateName() {
        txtFirstName.setText(presenter.getFirstName());
        txtLastName.setText(presenter.getLastName());


    }

    private Drawable getDrawablePopularity(Popularity popularity) {
        if (popularity.equals(Popularity.NORMAL)) {
            return ContextCompat.getDrawable(this, R.drawable.ic_person_black_96dp);
        } else {
            return ContextCompat.getDrawable(this, R.drawable.ic_whatshot_black_96dp);
        }

    }

    private int getAssociatedColor(Popularity popularity) {
        switch (popularity) {
            case NORMAL:
                return ContextCompat.getColor(this, android.R.color.black);
            case POPULAR:
                return ContextCompat.getColor(this, R.color.colorPopular);
            case STAR:
                return ContextCompat.getColor(this, R.color.colorStar);
        }
        return ContextCompat.getColor(this, R.color.colorStar);
    }


}
