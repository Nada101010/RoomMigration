package com.idemia.roomdbmigration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.idemia.roomdbmigration.databinding.ActivityGetBookBinding;
import com.idemia.roomdbmigration.viewmodels.book.BookViewModel;

public class GetDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityGetBookBinding binding = ActivityGetBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBookData().observe(this, bookList -> {
            BookAdapter bookAdapter = new BookAdapter(this, bookList);
            binding.rvBooks.setLayoutManager(new LinearLayoutManager(this));
            binding.rvBooks.setAdapter(bookAdapter);
        });

    }
}