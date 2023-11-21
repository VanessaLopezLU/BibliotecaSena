package com.example.bibliotecasena;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bibliotecasena.interfaz.EstadoUserAPI;
import com.example.bibliotecasena.interfaz.RolAPI;
import com.example.bibliotecasena.interfaz.UserAPI;
import com.example.bibliotecasena.modelos.User.User;
import com.example.bibliotecasena.modelos.EstadoUsuario.EstadoUsuario;
import com.example.bibliotecasena.modelos.Rol.Rol;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registrar extends AppCompatActivity {

    Spinner Rol;
    Spinner EstadoUser;
    List<Rol> roles;

    List<EstadoUsuario> estadousuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);



        Button guardarButton = findViewById(R.id.guardar);
        EditText Nombre = findViewById(R.id.editName);
        EditText Apellido = findViewById(R.id.editLastname);
        EditText Cedula = findViewById(R.id.cedula);
        EditText Contrasena = findViewById(R.id.pass);
        EditText Usuario = findViewById(R.id.usuario);
        EditText Telefono = findViewById(R.id.tel);
        EditText Correo = findViewById(R.id.correo);
        Rol = findViewById(R.id.spriRol);
        obtenerRoles();
        EstadoUser = findViewById(R.id.spriEstado);
        obtenerEstado();





        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Long cedula = Long.valueOf(Cedula.getText().toString());
                String nombre = Nombre.getText().toString();
                String apellido = Apellido.getText().toString();
                String correo = Correo.getText().toString();
                Long telefono = Long.valueOf(Telefono.getText().toString());
                String usuario  = Usuario.getText().toString();
                String contrasena = Contrasena.getText().toString();
                int id_rol = obtenerIdRol();
                int  id_estado = obtenerIdestado();
                // Suponiendo que tienes un constructor en la clase User con estos parámetros en este orden


                User user = new User (cedula, nombre,apellido,correo, telefono, usuario, contrasena, id_rol,id_estado);

                  createUser(user);


                /*

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
                }*/
                Intent intent = new Intent(Registrar.this, Login.class);
                startActivity(intent);

              }


            });

    }
    private void createUser(User user) {
        UserAPI userAPI = new ClienteAPI().getClient().create(UserAPI.class);
        Call<User> call = userAPI.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    // La petición fue exitosa, procesa la respuesta
                    User createdUser = response.body();
                    // Maneja la respuesta como desees, por ejemplo, muestra un mensaje de éxito
                    Toast.makeText(Registrar.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    // La petición no fue exitosa, maneja el error
                    Toast.makeText(Registrar.this, "Error al crear usuario", Toast.LENGTH_SHORT).show();
                    Log.e("CreateUserError", "Error al crear usuario: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Error en la conexión o al realizar la petición
                Toast.makeText(Registrar.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("CreateUserFailure", "Error de conexión: " + t.getMessage());
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
                     roles = response.body();

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
    private int obtenerIdRol() {
        String rolSeleccionado = String.valueOf(Integer.parseInt(Rol.getSelectedItem().toString()));
        int id_rol = 0;
        Log.i("rol" , "r: "+rolSeleccionado+", id: "+id_rol);

        for (Rol rol : roles) {
            if (rol.getDescripcion().equals(rolSeleccionado)) {
                id_rol = rol.getId();
                break;
            }
        }

        return id_rol;
    }
    private int obtenerIdestado() {
        String estadoSeleccionado = String.valueOf(Integer.parseInt(EstadoUser.getSelectedItem().toString()));
        int id_estado = 0;


        for (EstadoUsuario  estadoUsuario : estadousuario ) {
            if (estadoUsuario .getEstado().equals(estadoSeleccionado)) {
                id_estado = estadoUsuario.getId();
                break;
            }
        }

        return id_estado;
    }


    private void obtenerEstado() {
        EstadoUserAPI estadoUserAPI = new ClienteAPI().getClient().create(EstadoUserAPI.class);
        Call<List<EstadoUsuario>> call = estadoUserAPI.obtenerEstado();

        call.enqueue(new Callback<List<EstadoUsuario>>() {
            @Override
            public void onResponse(Call<List<EstadoUsuario>> call, Response<List<EstadoUsuario>> response) {
                if (response.isSuccessful()) {
                    estadousuario = response.body();

                    // Crear un ArrayList de String para almacenar las descripciones de los roles
                    List<String> estado = new ArrayList<>();

                    // Agregar las descripciones de los roles al ArrayList
                    for (EstadoUsuario estadoUsuario :estadousuario) {
                        estado.add(estadoUsuario.getEstado());
                    }
                    Log.i("prue",estado.toString());
                    Toast.makeText(Registrar.this,"peticion exitosa",Toast.LENGTH_SHORT).show();

                    // Crear un ArrayAdapter con las descripciones y configurar el Spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Registrar.this, android.R.layout.simple_spinner_item, estado);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    EstadoUser.setAdapter(adapter);

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
            public void onFailure(Call<List<EstadoUsuario>> call, Throwable t) {
                Toast.makeText(Registrar.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Prueba", t.getMessage());
                Log.e("Error", "Error de conexión: " + t);


            }
        });

    }


};