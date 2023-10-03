package com.example.bibliotecasena;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.bibliotecasena.modelos.User.LoginUsuario;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserAPI userService = ClienteAPI.getClient().create(UserAPI.class);

        Basedatos BD = new Basedatos(Login.this, "Basedatos", 1);
        EditText usuario = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        Button startButton = findViewById(R.id.iniciar);
        Button regisButton = findViewById(R.id.regis);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.i("login", "Llego al click");
                    int  cedula = Integer.parseInt(usuario.getText().toString());
                    String contrasena = password.getText().toString();


                    LoginUsuario request = new LoginUsuario((long) cedula, "contrasena");


                    Call<Boolean> call = userService.loginUser(request);

                    call.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if (response.isSuccessful()) {
                                boolean isSuccess = response.body();
                                if (response.isSuccessful()) {
                                    // Autenticación exitosa, inicia la actividad principal
                                    Intent intent = new Intent(Login.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    // Autenticación fallida
                                    Toast.makeText(Login.this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                // Error en la respuesta
                                Toast.makeText(Login.this, "Error en la respuesta del servidor", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            // Error en la conexión
                            Toast.makeText(Login.this, "Error de red: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
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
}
