package com.example.themxoasuasanpham.model.unit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumUnit {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("unit_name")
    @Expose
    private String unitName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}
