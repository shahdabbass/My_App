package com.example.myapp.data.producttable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public long pId;
    private String pName;
    private String pMaterial;



    //get/set

    //pid
    public long getPId() {
        return pId;
    }

    public void setPId(long pId) {
        this.pId = pId;
    }

    // pname
    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    //pm


    public String getPMaterial() {
        return pMaterial;
    }

    public void setPMaterial(String pMaterial) {
        this.pMaterial = pMaterial;
    }


    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pMaterial='" + pMaterial + '\'' +
                '}';
    }
}
