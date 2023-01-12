package com.idemia.roomdbmigration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.idemia.roomdbmigration.databinding.ActivityInsertBinding;
import com.idemia.roomdbmigration.db.entitiy.book.Book;
import com.idemia.roomdbmigration.viewmodels.book.BookViewModel;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityInsertBinding binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.edittextName.getText().toString();
                String author = binding.edittextAuthor.getText().toString();
                Book book = new Book(name, author);
                insert(book);
            }
        });

    }

    private void insert(Book book) {
        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        bookViewModel.insertBook(book).observe(this, insertedRow -> {
            if (insertedRow == 0) {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}