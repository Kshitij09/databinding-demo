package com.kshitijpatil.databindingdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.databindingdemo.data.ProfilePresenter;
import com.kshitijpatil.databindingdemo.databinding.ActivityOldBinding;

public class OldActivity extends AppCompatActivity {

    ProfilePresenter presenter;
    ActivityOldBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_old);

        presenter = new ProfilePresenter();
        binding.setLifecycleOwner(this);
        binding.setUser(presenter.getUser());
        binding.setPresenter(presenter);
    }

}
