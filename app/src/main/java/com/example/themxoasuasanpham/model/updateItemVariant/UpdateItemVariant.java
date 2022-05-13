package com.example.themxoasuasanpham.model.updateItemVariant;

import com.example.themxoasuasanpham.model.product.MessageObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateItemVariant {

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
    private DataUpdateItemVariant data;

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

    public DataUpdateItemVariant getData() {
        return data;
    }

    public void setData(DataUpdateItemVariant data) {
        this.data = data;
    }

}
