package com.example.themxoasuasanpham.model.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("unit_id")
    @Expose
    private Integer unitId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("total_stock")
    @Expose
    private Integer totalStock;
    @SerializedName("stock_limit")
    @Expose
    private Integer stockLimit;
    @SerializedName("main_image")
    @Expose
    private Object mainImage;
    @SerializedName("item_variants_count")
    @Expose
    private Integer itemVariantsCount;
    @SerializedName("stock_status")
    @Expose
    private StockStatus stockStatus;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("unit")
    @Expose
    private Unit unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Object getMainImage() {
        return mainImage;
    }

    public void setMainImage(Object mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getItemVariantsCount() {
        return itemVariantsCount;
    }

    public void setItemVariantsCount(Integer itemVariantsCount) {
        this.itemVariantsCount = itemVariantsCount;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}
