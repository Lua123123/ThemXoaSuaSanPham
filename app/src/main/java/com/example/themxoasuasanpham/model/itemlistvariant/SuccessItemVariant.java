package com.example.themxoasuasanpham.model.itemlistvariant;

import java.io.Serializable;

public class SuccessItemVariant implements Serializable {
    private String nameVariant;
    private String priceVariant;
    private String totalStockVariant;
    private String cartStockVariant;
    private String sizeVariant;
    private String colorVariant;
    private String imageVariant;
    private String item_id;
    private String id;

    public SuccessItemVariant(String nameVariant, String priceVariant, String totalStockVariant, String cartStockVariant, String sizeVariant, String colorVariant, String imageVariant, String item_id, String id) {
        this.nameVariant = nameVariant;
        this.priceVariant = priceVariant;
        this.totalStockVariant = totalStockVariant;
        this.cartStockVariant = cartStockVariant;
        this.sizeVariant = sizeVariant;
        this.colorVariant = colorVariant;
        this.imageVariant = imageVariant;
        this.item_id = item_id;
        this.id = id;
    }

    public String getNameVariant() {
        return nameVariant;
    }

    public void setNameVariant(String nameVariant) {
        this.nameVariant = nameVariant;
    }

    public String getPriceVariant() {
        return priceVariant;
    }

    public void setPriceVariant(String priceVariant) {
        this.priceVariant = priceVariant;
    }

    public String getTotalStockVariant() {
        return totalStockVariant;
    }

    public void setTotalStockVariant(String totalStockVariant) {
        this.totalStockVariant = totalStockVariant;
    }

    public String getCartStockVariant() {
        return cartStockVariant;
    }

    public void setCartStockVariant(String cartStockVariant) {
        this.cartStockVariant = cartStockVariant;
    }

    public String getSizeVariant() {
        return sizeVariant;
    }

    public void setSizeVariant(String sizeVariant) {
        this.sizeVariant = sizeVariant;
    }

    public String getColorVariant() {
        return colorVariant;
    }

    public void setColorVariant(String colorVariant) {
        this.colorVariant = colorVariant;
    }

    public String getImageVariant() {
        return imageVariant;
    }

    public void setImageVariant(String imageVariant) {
        this.imageVariant = imageVariant;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuccessItemVariant{" +
                "nameVariant='" + nameVariant + '\'' +
                ", priceVariant='" + priceVariant + '\'' +
                ", totalStockVariant='" + totalStockVariant + '\'' +
                ", cartStockVariant='" + cartStockVariant + '\'' +
                ", sizeVariant='" + sizeVariant + '\'' +
                ", colorVariant='" + colorVariant + '\'' +
                ", imageVariant='" + imageVariant + '\'' +
                ", item_id='" + item_id + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
