package com.example.bibliotecasena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bibliotecasena.interfaz.RolAPI;
import com.example.bibliotecasena.interfaz.UserAPI;
import com.example.bibliotecasena.modelos.Rol.Rol;
import com.example.bibliotecasena.modelos.User.User;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registrar<UserDto> extends AppCompatActivity {

    Spinner Rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);



        Button guardarButton = findViewById(R.id.guardar);
        EditText Nombre = findViewById(R.id.editName);
        EditText Cedula = findViewById(R.id.usuario);
        EditText Contrasena = findViewById(R.id.pass);
        Rol = findViewById(R.id.spriRol);
        EditText Telefono = findViewById(R.id.tel);
        EditText Direccion = findViewById(R.id.dire);
        EditText Correo = findViewById(R.id.correo);
        obtenerRoles();





        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  /* UserAPI userAPI = ClienteAPI.getClient().create(UserAPI.class);
                String nombre = Nombre.getText().toString();
                String cedula = Cedula.getText().toString();
                String contrasena = Contrasena.getText().toString();
                String telefono = Telefono.getText().toString();
                String direccion = Direccion.getText().toString();
                String correo = Correo.getText().toString();
                String rolSeleccionado = Rol.getSelectedItem().toString();

                User user = new User();
                user.setNombre(nombre);
                usersetCedula(Integer.parseInt(cedula));
                user.setContrasena(contrasena);
                user.setTelefono(Integer.parseInt(telefono));
                user.setDireccion(direccion);
                user.setCorreo(correo);



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
                // insert into usurio values ("1003047036","leydis vanessa","Va123","leylopez32@gmail.com,3003379075,"diagonal 2", 2 )
                //insert INTO ROLES VALUES(2,"Administrativo");

                String rolSeleccionado = Rol.getSelectedItem().toString();

                JSONArray CedulaArray = BD.getJSON("SELECT CEDULA FROM USUARIO WHERE CEDULA = " + Cedula.getText().toString(), new String[]{"CEDULA"});
                if ( CedulaArray.length() > 0) {
                    Toast.makeText(Registrar.this, "Usuario ya existe ", Toast.LENGTH_LONG).show();
                }
                else {
                    BD.Escribir("insert into USUARIO values(\""+Cedula.getText().toString()+"\",\""+Nombre.getText().toString()+"\",\""+Contrasena.getText().toString()+"\",\""+Correo.getText().toString()+"\",\""+Telefono.getText().toString()+"\",\""+Direccion.getText().toString()+"\",\""+ rolSeleccionado + "\")");
                    Toast.makeText(Registrar.this, "Usuario Registrado ", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(Registrar.this, Login.class);
                startActivity(intent);*/
              }


            });

    }
    private void obtenerRoles(){


        RolAPI rolAPI = new ClienteAPI().getClient().create(RolAPI.class);
        Call< List<Rol>> call = rolAPI.obtenerRoles();

        call.enqueue(new Callback<List<Rol>>() {
            @Override
            public void onResponse(Call<List<Rol>> call, Response<List<Rol>> response) {

                if (response.isSuccessful()) {
                    List<Rol> roles = response.body();

                    // Crear un ArrayList de String para almacenar las descripciones de los roles
                    List<String> roleDescriptions = new ArrayList<>();

                    // Agregar las descripciones de los roles al ArrayList
                    for (Rol rol : roles) {
                        roleDescriptions.add(rol.getDescripcion());
                    }
                    Log.i("prue",roleDescriptions.toString());
                    Toast.makeText(Registrar.this,"peticion exitosa",Toast.LENGTH_SHORT).show();

                   // Crear un ArrayAdapter con las descripciones y configurar el Spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Registrar.this, android.R.layout.simple_spinner_item, roleDescriptions);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    Rol.setAdapter(adapter);

                }
                else {
                    if (response.code() == 404) {
                        Toast.makeText(Registrar.this, "Recurso no encontrado", Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 500) {

                        Toast.makeText(Registrar.this, "Error del servidor", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(Registrar.this, "Error desconocido", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Rol>> call, Throwable t) {
                Toast.makeText(Registrar.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Prueba", t.getMessage());
                Log.e("Error", "Error de conexión: " + t);

            }
        });

    }

};