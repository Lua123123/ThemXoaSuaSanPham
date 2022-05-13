package com.example.themxoasuasanpham.model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumCategory {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cate_name")
    @Expose
    private String cateName;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("item_count")
    @Expose
    private Object itemCount;
    @SerializedName("level")
    @Expose
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Object getItemCount() {
        return itemCount;
    }

    public void setItemCount(Object itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
