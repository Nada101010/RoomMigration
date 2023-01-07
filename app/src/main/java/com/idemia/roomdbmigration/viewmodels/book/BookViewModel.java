package com.idemia.roomdbmigration.viewmodels.book;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.idemia.roomdbmigration.viewmodels.book.model.Book;

public class BookViewModel extends AndroidViewModel {

    private BookRepository bookRepository;

    public BookViewModel(@NonNull Application application) {
        super(application);

        bookRepository = new BookRepository();
    }

    public void insertBook(Book book) {
        bookRepository.insertBook(book);
    }

    public Book getBookData() {
        return bookRepository.getBookData();
    }
}
