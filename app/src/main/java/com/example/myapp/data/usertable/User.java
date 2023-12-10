package com.example.myapp.data.usertable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "User")

public class User {


        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "Id")
        public long Id;

        @ColumnInfo(name = "name")
        private String name;

        @ColumnInfo(name = "residence")
        private String residence;

        @ColumnInfo(name = "gender")
        private String gender;


        // Constructors, getters, and setters

        public User() {}

        public long getId() {
            return Id;
        }

        public void setId(long id) {
            this.Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResidence() {
            return residence;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", residence='" + residence + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

