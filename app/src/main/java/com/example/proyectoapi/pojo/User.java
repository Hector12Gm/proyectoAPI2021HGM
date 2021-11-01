package com.example.proyectoapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("telfono")
    @Expose
    private String telfono;
    @SerializedName("correo")
    @Expose
    private String correo;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param password
     * @param correo
     * @param name
     * @param telfono
     */

    public User(String name, String password, String telfono, String correo) {

        this.name = name;
        this.password = password;
        this.telfono = telfono;
        this.correo = correo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelfono() {
        return telfono;
    }

    public void setTelfono(String telfono) {
        this.telfono = telfono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
