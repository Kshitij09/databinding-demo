package com.kshitijpatil.databindingdemo.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;

import com.kshitijpatil.databindingdemo.R;
import com.kshitijpatil.databindingdemo.data.ProfilePresenter;

public class BindingAdaptors {
    @BindingAdapter("app:hideIfZero")
    public static void hideIfZero(View view, int likes) {
        view.setVisibility((likes == 0) ? View.GONE : View.VISIBLE);
    }

    @BindingAdapter({"app:progress_scaled", "android:max"})
    public static void setProgress(ProgressBar progressBar, int likes, int max) {
        progressBar.setProgress(likes * max / 10);
    }

    @BindingAdapter("app:popularity")
    public static void setPopularity(ImageView imageView, ProfilePresenter.Popularity popularity) {
        int color = getAssociatedColor(imageView.getContext(), popularity);

        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color));

        imageView.setImageDrawable(getDrawableFor(imageView.getContext(), popularity));
    }

    private static Drawable getDrawableFor(Context context, ProfilePresenter.Popularity popularity) {
        if (popularity.equals(ProfilePresenter.Popularity.NORMAL))
            return ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp);
        else
            return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
    }

    private static int getAssociatedColor(Context context, ProfilePresenter.Popularity popularity) {
        switch (popularity) {
            case NORMAL:
                return ContextCompat.getColor(context, android.R.color.black);
            case POPULAR:
                return ContextCompat.getColor(context, R.color.colorPopular);
            case STAR:
                return ContextCompat.getColor(context, R.color.colorStar);
        }
        return ContextCompat.getColor(context, android.R.color.black);
    }
}


