package com.idemia.roomdbmigration.db.entitiy.book;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class BookDao {

    @Insert()
    public abstract long insert(Book book);

    @Query("SELECT * FROM book")
    public abstract List<Book> getAllBooks();
}