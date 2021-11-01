package com.example.proyectoapi.service;

import com.example.proyectoapi.pojo.Mensaje;
import com.example.proyectoapi.pojo.User;

import retrofit2.Callback;

public class UserService {
    private Service service;

    public UserService(){
        this.service = new Service();
    }

    public void login(String name,String password,Callback<Mensaje> response){

        service.getUserService().login(name,password).enqueue(response);

    }

    public void  signUp(User user, Callback<Mensaje> response){

        service.getUserService().signup(user).enqueue(response);

    }



}
