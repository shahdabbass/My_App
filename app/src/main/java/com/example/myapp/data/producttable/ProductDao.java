package com.example.myapp.data.producttable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapp.data.usertable.User;

import java.util.List;

@Dao

public interface ProductDao {
    @Query("SELECT * FROM User")
    List<Product> getAll();
    @Query("SELECT * FROM User where Id == (:InfoId)")
    Product getInfoByInfoId(long InfoId);

    @Insert
    long insert(User I);

    @Update
    void update(User info);

    @Delete
    void delete(User info);

}
