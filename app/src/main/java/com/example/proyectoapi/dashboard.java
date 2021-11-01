package com.example.proyectoapi;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


    }

    public void cerrarClick(View view){
            this.finish();
    }
    @Override
    public void onBackPressed() {

    }
}