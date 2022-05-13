package com.example.themxoasuasanpham.model.category;

import java.util.List;

import com.example.themxoasuasanpham.model.product.MessageObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategorySpinnerProduct {

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
    private List<DatumCategory> data = null;

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

    public List<DatumCategory> getData() {
        return data;
    }

    public void setData(List<DatumCategory> data) {
        this.data = data;
    }

}
