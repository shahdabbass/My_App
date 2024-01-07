package com.example.myapp.data.producttable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity                //لنتمكن من نقب الكائن بواسطة انتنت
public class Product implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public long IdP;
    private String NameP;
    private String Material;
    private String ReT;
    private String BrcodP;


    public long getIdP() {
        return IdP;
    }

    public void setIdP(long idP) {
        IdP = idP;
    }

    public String getNameP() {
        return NameP;
    }

    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getReT() {
        return ReT;
    }

    public void setReT(String reT) {
        this.ReT = reT;
    }

    public String getBrcodP() {
        return BrcodP;
    }

    public void setBrcodP(String brcodP) {
        BrcodP = brcodP;
    }

    @Override
    public String toString() {
        return "Product{" +
                "IdP=" + IdP +
                ", NameP='" + NameP + '\'' +
                ", Material='" + Material + '\'' +
                ", ReT='" + ReT + '\'' +
                ", BrcodP='" + BrcodP + '\'' +
                '}';
    }
}
