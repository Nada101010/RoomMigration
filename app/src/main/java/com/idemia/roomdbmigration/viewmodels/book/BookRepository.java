package com.idemia.roomdbmigration.viewmodels.book;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.idemia.roomdbmigration.db.config.AppDatabase;
import com.idemia.roomdbmigration.db.entitiy.book.Book;
import com.idemia.roomdbmigration.db.entitiy.book.BookDao;

import java.util.List;

class BookRepository {

    BookDao bookDao;

    public BookRepository(Context context) {
        bookDao = AppDatabase.getDatabase(context).bookDao();
    }

    public MutableLiveData<Long> insertBook(Book book) {
        MutableLiveData<Long> insertedBook = new MutableLiveData<>();
        insertedBook.setValue(bookDao.insert(book));
        return insertedBook;
    }

    public MutableLiveData<List<Book>> getBookData() {
        MutableLiveData<List<Book>> bookListMutable = new MutableLiveData<List<Book>>();
        bookListMutable.setValue(bookDao.getAllBooks());
        return bookListMutable;
    }
}
