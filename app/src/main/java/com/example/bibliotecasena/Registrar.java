package com.example.bibliotecasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;

import java.lang.reflect.Array;

public class Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Button guardarButton = findViewById(R.id.guardar);
        EditText Nombre = findViewById(R.id.editName);
        EditText Cedula = findViewById(R.id.usuario);
        EditText Contrasena = findViewById(R.id.pass);
        Spinner  Rol = findViewById(R.id.spriRol);
        EditText Telefono = findViewById(R.id.tel);
        EditText Direccion = findViewById(R.id.dire);
        EditText Correo = findViewById(R.id.correo);



        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Basedatos BD = new Basedatos(Registrar.this, "Basedatos", 1);
                int RolDatabase = 0;
                switch (Rol.getSelectedItem().toString()) {
                    case "Administrador":
                        RolDatabase = 1;
                        break;
                    case "Funcionario":
                        RolDatabase = 2;
                        break;
                    case "Instructores":
                        RolDatabase = 3;
                        break;
                }
                // insert into usurio values ("1003047036","leydis vanessa","Va123","leylopez32@gmail.com,3003379075,"diadonal 2", 2 )
                //insert INTO ROLES VALUES(2,"administrativo");

                JSONArray CedulaArray = BD.getJSON("SELECT CEDULA FROM USUARIO WHERE CEDULA = " + Cedula.getText().toString(), new String[]{"CEDULA"});
                if ( CedulaArray.length() > 0) {
                    Toast.makeText(Registrar.this, "Usuario ya existe ", Toast.LENGTH_LONG).show();
                }
                else {
                    BD.Escribir("insert into USUARIO values(\""+Cedula.getText().toString()+"\",\""+Nombre.getText().toString()+"\",\""+Contrasena.getText().toString()+"\",\""+Correo.getText().toString()+"\",\""+Telefono.getText().toString()+"\",\""+Direccion.getText().toString()+"\","+RolDatabase + ")");
                    Toast.makeText(Registrar.this, "Usuario Registrado ", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(Registrar.this, Login.class);
                startActivity(intent);
              }


            });

    }

};