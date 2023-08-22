package com.example.bibliotecasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

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
                 Log.i("login","Llego sal click");
                 JSONArray login =  BD.getJSON("SELECT CEDULA FROM USUARIO WHERE CEDULA = " + usuario.getText().toString()+ " AND CONTRASENA = '"+ password.getText().toString() + "';",new String[]{"CEDULA", "CONTRASENA"});
                 Log.i("login","Paso la bd");
                 if (login.length()>0){
                     Intent intent = new Intent(Login.this, MainActivity.class);
                     startActivity(intent);
                 } else {
                     Log.i("login","toast");
                     Toast.makeText(Login.this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                 }
             }
             catch (Exception error) {
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






