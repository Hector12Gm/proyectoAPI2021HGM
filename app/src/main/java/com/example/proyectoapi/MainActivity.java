package com.example.proyectoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoapi.pojo.Mensaje;
import com.example.proyectoapi.service.UserService;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv_registro_click;
    EditText edtName;
    EditText edtPassword;
    Button btnLogin;
    RelativeLayout loadingscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_registro_click = (TextView) findViewById(R.id.tvRegistroClick);
        this.edtName = (EditText) findViewById( R.id.edtUsername );
        this.edtPassword = (EditText) findViewById( R.id.edtPassword );
        this.loadingscreen = ( RelativeLayout ) findViewById(R.id.loadingScreen);

        tv_registro_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

    }

    public void clickLogin(View v){
        if(!this.edtName.getText().toString().isEmpty() && !this.edtPassword.getText().toString().isEmpty()){
            UserService user = new UserService();
            this.loadingscreen.setVisibility(View.VISIBLE);
            user.login(this.edtName.getText().toString(), this.edtPassword.getText().toString(), new Callback<Mensaje>() {
                @Override
                public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                    if(response.code() == 200){
                        loadingscreen.setVisibility(View.GONE);
                        edtName.setText("");
                        edtPassword.setText("");
                        startActivity(new Intent(MainActivity.this,dashboard.class));
                    }else{
                        loadingscreen.setVisibility(View.GONE);
                        Snackbar.make(v, "Contraseña y/o usuario incorrectos", Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Mensaje> call, Throwable t) {
                    Snackbar.make(v, "Error fatal", Snackbar.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        }else{
            Snackbar.make(v, "Llena todos los campos", Snackbar.LENGTH_SHORT).show();
        }

    }
}