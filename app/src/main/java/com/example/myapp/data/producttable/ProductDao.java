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
    @Query("SELECT * FROM Product")
    List<Product> getAll();
    @Query("SELECT * FROM Product where IdP == (:InfoId)")
    Product getInfoByInfoId(long InfoId);
    @Query("SELECT * FROM Product WHERE BrcodP = :myBrcode  LIMIT 1  ")
    Product searchAndCheckBrcode(String myBrcode);

    @Insert
    long insert(Product I);

    @Update
    void update(Product info);

    @Delete
    void delete(Product info);
    @Query("SELECT * FROM Product WHERE BrcodP = :myBrcode  LIMIT 1  ")
    Product checkBrcode(String myBrcode);

}
