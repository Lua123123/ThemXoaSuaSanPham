package com.example.themxoasuasanpham.model.itemlistvariant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockStatusItemListVariant {

    @SerializedName("warning_stock")
    @Expose
    private Boolean warningStock;
    @SerializedName("total_stock")
    @Expose
    private Integer totalStock;
    @SerializedName("out_of_stock")
    @Expose
    private Boolean outOfStock;

    public Boolean getWarningStock() {
        return warningStock;
    }

    public void setWarningStock(Boolean warningStock) {
        this.warningStock = warningStock;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Boolean getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

}