package com.example.proyectoapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Mensaje {

    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     */
    public Mensaje() {
    }

    /**
     * @param message
     */
    public Mensaje(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
