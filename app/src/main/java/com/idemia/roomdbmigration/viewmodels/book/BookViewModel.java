package com.idemia.roomdbmigration.viewmodels.book;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.idemia.roomdbmigration.db.entitiy.book.Book;

import java.util.List;


public class BookViewModel extends AndroidViewModel {

    private BookRepository bookRepository;

    public BookViewModel(@NonNull Application application) {
        super(application);

        bookRepository = new BookRepository(getApplication().getApplicationContext());
    }

    public MutableLiveData<Long> insertBook(Book book) {
        return bookRepository.insertBook(book);
    }

    public MutableLiveData<List<Book>> getBookData() {
        return bookRepository.getBookData();
    }
}
