package com.example.themxoasuasanpham.model.updateItemVariant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUpdateItemVariant {

    @SerializedName("total_stock")
    @Expose
    private Integer totalStock;

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

}