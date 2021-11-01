package com.example.proyectoapi.service;

import com.example.proyectoapi.pojo.Mensaje;
import com.example.proyectoapi.pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IUserService {
    @POST("users/login")
    @FormUrlEncoded
    Call <Mensaje> login(@Field("nombre") String nombre, @Field("password") String password);

    @POST("users/signup")
    Call<Mensaje> signup(@Body User usuario);
}
