package com.example.themxoasuasanpham.model.product;

public class SuccessProduct {

    private String nameProduct;
    private String cateName;
    private String variantCount;
    private String price;
    private String imageProduct;

    public SuccessProduct(String nameProduct, String cateName, String variantCount, String price, String imageProduct) {
        this.nameProduct = nameProduct;
        this.cateName = cateName;
        this.variantCount = variantCount;
        this.price = price;
        this.imageProduct = imageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getVariantCount() {
        return variantCount;
    }

    public void setVariantCount(String variantCount) {
        this.variantCount = variantCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}
