package com.example.proyectoapi.service;

import com.example.proyectoapi.pojo.Mensaje;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class CallBackResponse implements Callback<Mensaje> {
    public boolean complete = false;


    @Override
    public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
        if(response.code() == 200)
            this.complete = true;
        else
            this.complete = false;
    }

    @Override
    public void onFailure(Call<Mensaje> call, Throwable t) {
        this.complete = false;
        t.printStackTrace();
    }
}