package com.example.bibliotecasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bibliotecasena.modelos.User.User;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Basedatos BD = new Basedatos(Login.this, "Basedatos", 1);
        EditText usuario = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        Button startButton = findViewById(R.id.iniciar);
        Button regisButton = findViewById(R.id.regis);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.i("login", "Llegó al click");
                    JSONArray login = BD.getJSON("SELECT CEDULA FROM USUARIO WHERE CEDULA = " + usuario.getText().toString() + " AND CONTRASENA = '" + password.getText().toString() + "';", new String[]{"CEDULA", "CONTRASENA"});
                    Log.i("login", "Pasó la bd");

                    if (login.length() > 0) {
                        // Si la autenticación es exitosa, realiza la solicitud Retrofit
                        obtenerUsuarios();
                    } else {
                        Log.i("login", "toast");
                        Toast.makeText(Login.this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception error) {
                    Log.i("login", error.toString());
                }
            }
        });



        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registrar.class);
                startActivity(intent);

            }

        });
    }

    private void obtenerUsuarios() {
        UserAPI userService = ClienteAPI.getClient().create(UserAPI.class);

        Call<List<User>> call = userService.getUsers(Integer.parseInt("user/obtener"));
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    // Haz algo con los datos obtenidos
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Maneja errores
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // Maneja errores de red
            }
        });
    }
}






