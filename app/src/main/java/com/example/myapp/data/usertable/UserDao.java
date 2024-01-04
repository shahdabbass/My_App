package com.example.myapp.data.usertable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapp.data.producttable.Product;

import java.util.List;
@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();
    @Query("SELECT * FROM User WHERE id IN (:userIds)")
     List<User> loadAllByIds(int[] userIds);
    @Query("SELECT * FROM User WHERE email = :myEmail AND passw =:myPassw LIMIT 1  ")
    User checkEmail(String myEmail, String myPassw);
   // @Query("SELECT * FROM User where Id == (:InfoId)")
  //  User getInfoByInfoId(long InfoId);

    @Insert
    long insert(User I);

    @Update
    void update(User info);

    @Delete
    void delete(User info);


    User checkEmailPass(String email, String password);
}