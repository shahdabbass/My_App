package com.example.myapp.data.producttable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public long etIdP;
    private String etNameP;
    private String etMaterial;
    private String etReT;



    //get/set

    //pid
    public long getPId() {
        return etIdP;
    }

    public void setetIdP(long pId) {
        this.etIdP = pId;
    }

    // pname
    public String getPName() {
        return etNameP;
    }

    public void setetNameP(String pName) {
        this.etNameP = pName;
    }

    //pm


    public String getPMaterial() {
        return etMaterial;
    }

    public void setetMaterial(String pMaterial) {
        this.etMaterial = pMaterial;
    }

    //pR


    public String getEtReT() {
        return etReT;
    }

    public void setEtReT(String etReT) {
        this.etReT = etReT;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + etIdP +
                ", pName='" + etNameP + '\'' +
                ", pMaterial='" + etMaterial + '\'' +
                '}';
    }
}
