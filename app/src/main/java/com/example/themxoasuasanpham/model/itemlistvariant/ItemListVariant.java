package com.example.themxoasuasanpham.model.itemlistvariant;

import com.example.themxoasuasanpham.model.product.MessageObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemListVariant {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("messageObject")
    @Expose
    private MessageObject messageObject;
    @SerializedName("data")
    @Expose
    private List<DatumItemListVariant> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageObject getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(MessageObject messageObject) {
        this.messageObject = messageObject;
    }

    public List<DatumItemListVariant> getData() {
        return data;
    }

    public void setData(List<DatumItemListVariant> data) {
        this.data = data;
    }

}
