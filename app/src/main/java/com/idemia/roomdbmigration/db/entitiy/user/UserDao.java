package com.idemia.roomdbmigration.db.entitiy.user;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class UserDao {

    @Insert()
    public abstract void insert(User user);

    @Query("SELECT * FROM user WHERE username = :userName AND user_password = :password")
    public abstract User getUserByNameAndPassword(String userName, String password);

    @Query("SELECT * FROM user WHERE username = :userName ")
    public abstract User getUserByUsername(String userName);

    @Query("SELECT * FROM user WHERE is_active = 1")
    public abstract User getActiveUser();

    @Query("UPDATE user SET is_active = 1 WHERE username = :userName AND user_password = :password")
    public abstract void activateUser(String userName, String password);

    @Query("UPDATE user SET is_active = 1 WHERE username = :userName")
    public abstract void activateUserWithCard(String userName);

    @Query("UPDATE user SET finger_state = :fingerPrint WHERE username = :username")
    public abstract void updateUser(String username, byte[] fingerPrint);

    @Query("SELECT * FROM user")
    public abstract List<User> getAllUsers();

    @Query("DELETE FROM user ")
    public abstract void deleteAllUsers();

}
