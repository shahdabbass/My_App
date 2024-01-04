package com.example.myapp.data.usertable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "User")

public class User {


        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "Id")
        public long Id;

        public String email;

        @ColumnInfo(name = "name")
        private String name;

        private String password;

        @ColumnInfo(name = "phone")
        private String phone;


        // Constructors, getters, and setters

        public User() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", residence='" + password + '\'' +
                ", gender='" + phone + '\'' +
                '}';
    }
}

