package com.idemia.roomdbmigration.db.entitiy.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")

public class User {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "user_fullName")
    private String userFullName;

    @ColumnInfo(name = "user_password")
    private String userPassword;

    @ColumnInfo(name = "national_id")
    private String nationalId;

    @ColumnInfo(name = "finger_state", typeAffinity = ColumnInfo.BLOB)
    private byte[] userFingerTemplate;

    @ColumnInfo(name = "is_active")
    private int isActive;

    public User() {
    }

    public User(String username, String userFullName, String userPassword, String nationalId, byte[] userFingerTemplate, int isActive) {
        this.username = username;
        this.userFullName = userFullName;
        this.userPassword = userPassword;
        this.nationalId = nationalId;
        this.userFingerTemplate = userFingerTemplate;
        this.isActive = isActive;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public byte[] getUserFingerTemplate() {
        return userFingerTemplate;
    }

    public void setUserFingerTemplate(byte[] userFingerTemplate) {
        this.userFingerTemplate = userFingerTemplate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
