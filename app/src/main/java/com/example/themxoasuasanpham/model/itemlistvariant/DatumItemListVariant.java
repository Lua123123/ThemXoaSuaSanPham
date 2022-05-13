package com.example.themxoasuasanpham.model.itemlistvariant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumItemListVariant {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("total_stock")
    @Expose
    private Integer totalStock;
    @SerializedName("stock_limit")
    @Expose
    private Integer stockLimit;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("stock_status")
    @Expose
    private StockStatusItemListVariant stockStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getStockLimit() {
        return stockLimit;
    }

    public void setStockLimit(Integer stockLimit) {
        this.stockLimit = stockLimit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StockStatusItemListVariant getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatusItemListVariant stockStatus) {
        this.stockStatus = stockStatus;
    }
}