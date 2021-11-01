package com.example.proyectoapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.proyectoapi.pojo.Mensaje;
import com.example.proyectoapi.pojo.User;
import com.example.proyectoapi.service.UserService;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends AppCompatActivity {


    private EditText edtSignUpName;
    private EditText edtSignUpPassword1;
    private EditText edtSignUpPassword2;
    private EditText edtSignUpTelefono;
    private EditText edtSignUpCorreo;
    private RelativeLayout loadingPantalla;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.myToolbar);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.edtSignUpName = (EditText) findViewById( R.id.edtSignName );
        this.edtSignUpPassword1 = (EditText) findViewById( R.id.edtSignPassword1);
        this.edtSignUpPassword2 = (EditText) findViewById( R.id.edtSignPassword2 );
        this.edtSignUpCorreo = (EditText) findViewById( R.id.edtSignCorreo );
        this.edtSignUpTelefono = (EditText) findViewById( R.id.edtSignTelefono );
        this.loadingPantalla = (RelativeLayout) findViewById( R.id.loadingPantall );

    }

    public void click_SignUp(View v){

        if(validarTexto()) {
            if (validarPassword()) {
                User usuario = new User();
                usuario.setName(this.edtSignUpName.getText().toString());
                usuario.setPassword(this.edtSignUpPassword1.getText().toString());
                usuario.setTelfono(this.edtSignUpTelefono.getText().toString());
                usuario.setCorreo(this.edtSignUpCorreo.getText().toString());

                UserService userService = new UserService();
                loadingPantalla.setVisibility(View.VISIBLE);
                userService.signUp(usuario, new Callback<Mensaje>() {
                    @Override
                    public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                        loadingPantalla.setVisibility(View.GONE);
                        if(response.code() == 200){

                            Snackbar.make(v, "Se registro", Snackbar.LENGTH_SHORT).show();
                            clearTxt();
                        }else{
                            Snackbar.make(v, "No se registro", Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Mensaje> call, Throwable t) {
                        loadingPantalla.setVisibility(View.GONE);
                        Snackbar.make(v, "Error fatal", Snackbar.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
            } else {
                Snackbar.make(v, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT).show();
            }
        }
        else{
            Snackbar.make(v, "Llenar todos los datos", Snackbar.LENGTH_SHORT).show();
        }
    }

    private boolean validarTexto(){
        String name = this.edtSignUpName.getText().toString();
        String password = this.edtSignUpPassword1.getText().toString();
        String correo = this.edtSignUpCorreo.getText().toString();
        String telefono = this.edtSignUpTelefono.getText().toString();


        if(!name.isEmpty() && !password.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()){
            return true;
        }else{
            return  false;
        }
    }
    private boolean validarPassword(){

        String password1 = this.edtSignUpPassword1.getText().toString();
        String password2 = this.edtSignUpPassword2.getText().toString();

        if(password1.compareTo(password2) == 0){
            return true;
        }else{
            return false;
        }
    }
    private void clearTxt(){
        this.edtSignUpName.setText("");
        this.edtSignUpPassword1.setText("");
        this.edtSignUpPassword2.setText("");
        this.edtSignUpCorreo.setText("");
        this.edtSignUpTelefono.setText("");

    }
}