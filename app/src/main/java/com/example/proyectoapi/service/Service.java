package com.example.proyectoapi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private Retrofit service;

    public Service(){
        this.service = new Retrofit.Builder().baseUrl(DATOSERVICE.URL_BASE).
                addConverterFactory(GsonConverterFactory.create()).build();

    }

    public IUserService getUserService(){
        return    this.service.create(IUserService.class);
    }

}
