package com.kshitijpatil.databindingdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.databindingdemo.databinding.ActivityMainBinding;
import com.kshitijpatil.databindingdemo.models.Note;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Note note = new Note("Android seminar", "Remember to talk about data binding while presentation");
        binding.setNote(note);
    }
}
