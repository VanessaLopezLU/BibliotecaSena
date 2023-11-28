package com.example.bibliotecasena;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bibliotecasena.modelos.User.User;

import org.json.JSONArray;
import org.json.JSONObject;

public class Basedatos extends SQLiteOpenHelper {
    public Basedatos(@Nullable Context context, @Nullable String name, int version) {
        super(context, name,  null , version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL = "CREATE TABLE IF NOT EXISTS ROLES(ID_ROL INT PRIMARY KEY, " +
                "DESCRIPCION TEXT" +
                ")";
        db.execSQL(strSQL);

        strSQL = "CREATE TABLE IF NOT EXISTS USUARIO(CEDULA TEXT PRIMARY KEY," +
                "NOMBRE TEXT," +
                "CONTRASENA  TEXT," +
                "CORREO TEXT," +
                "TELEFONO TEXT," +
                "DIRECCION TEXT,"+
                "ID_ROL INT," +
                "FOREIGN KEY (ID_ROL) REFERENCES ROLES (ID_ROL)"+
                ")";

        db.execSQL(strSQL);
        strSQL = "CREATE TABLE IF NOT EXISTS ESTADO_EQUIPO(ID_ESTADO INT PRIMARY KEY ," +
                "ESTADOS  TEXT" +
                ")";
        db.execSQL(strSQL);

        strSQL = "CREATE TABLE IF NOT EXISTS TIPO_EQUIPO(ID_TIPO INT PRIMARY KEY ," +
                "TIPO  TEXT" +
                ")";
        db.execSQL(strSQL);


        strSQL = "CREATE TABLE IF NOT EXISTS ESTADO_PRESTAMO(ID_ESTADOP TEXT PRIMARY KEY ," +
                "ESTADO_PRESAMO TEXT" +
                ")";
        db.execSQL(strSQL);

       strSQL = "CREATE TABLE IF NOT EXISTS PRESTAMO(ID_PRESTAMO INTEGER PRIMARY KEY AUTOINCREMENT," +
               "NUMERO_EQUIPOS INT ,"+
               "AMBIENTE TEXT ,"+
               "FECHAYHORA_PRESTAMO  TEXT," +
               "FECHAYHORA_DEVOLUCION TEXT," +
               "CEDULA  TEXT ," +
               "ID_ESTADOP TEXT," +
               "FOREIGN KEY (CEDULA) REFERENCES USUARIO (CEDULA)," +
               "FOREIGN KEY (ID_ESTADOP) REFERENCES ESTADO_PRESTAMO (ID_ESTADOP)" +
               ")";
       db.execSQL(strSQL);
        strSQL = "CREATE TABLE IF NOT EXISTS DETALLES_PRESTAMO( ID_PRESTAMO TEXT ," +
                "ID_EQUIPO  INT," +
                "FOREIGN KEY (ID_PRESTAMO) REFERENCES PRESTAMO  (ID_PRESTAMO)," +
                "FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS(ID_EQUIPO)" +
                ")";
        db.execSQL(strSQL);
        strSQL = "CREATE TABLE IF NOT EXISTS NOVEDADES( ID_NOVEDADES INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DESCRIPCION  TEXT," +
                "FECHA_NOVEDAD  TEXT," +
                "TIPO_NOVEDAD  TEXT," +
                "ID_PRESTAMO  INT," +
                "FOREIGN KEY (ID_PRESTAMO) REFERENCES PRESTAMO(ID_PRESTAMO)" +
                ")";
        db.execSQL(strSQL);
        strSQL = "CREATE TABLE IF NOT EXISTS EQUIPOS(" +
                "ID_EQUIPO INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SERIAL INTEGER," +
                "DESCRIPCION TEXT," +
                "ID_ESTADO INTEGER," +
                "ID_TIPO INTEGER," +
                "FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO_EQUIPO(ID_ESTADO)," +
                "FOREIGN KEY (ID_TIPO) REFERENCES TIPO_EQUIPO(ID_TIPO)" +
                ")";
        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void  Escribir(String strSQL) {
        SQLiteDatabase bibliotecaSena= this.getWritableDatabase();
        bibliotecaSena.execSQL(strSQL);
        bibliotecaSena.close();

    }

    @SuppressLint("Range")
    public JSONArray getJSON(String strSql, String[] columnas){
        JSONArray jsonArray = new JSONArray();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strSql, null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
            JSONObject jsonObject = new JSONObject();
            for(int j=0; j< columnas.length; j++){
                try {
                    jsonObject.put(columnas[j], cursor.getString(cursor.getColumnIndex(columnas[j])));

                }catch (Exception e){
                    Log.i("Mayor", e.toString());
                }
            }
            jsonArray.put(jsonObject);
            cursor.moveToNext();
        }
        db.close();
        return jsonArray;
    }





    // Método para insertar un usuario en la tabla USUARIO
    public void insertarUsuario(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Agregar los valores del usuario a la ContentValues
        values.put("CEDULA", user.getCedula());
        values.put("NOMBRE", user.getNombre());
        values.put("CONTRASENA", user.getContrasena());
        values.put("CORREO", user.getCorreo());
        values.put("TELEFONO", user.getTelefono());
        values.put("ID_ROL", (String) user.getIdRol());
        values.put("ID_ESTADO", (String) user.getIdestado());
        // Asegúrate de que el User tenga el método getIdRol()

        // Insertar el usuario en la tabla USUARIO
        db.insert("USUARIO", null, values);

        // Cerrar la conexión a la base de datos
        db.close();
    }

    // ... (otros métodos)

    // Método para obtener datos como JSONArray
    public JSONArray obtenerDatos(String strSql, String[] columnas) {
        JSONArray jsonArray = new JSONArray();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strSql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            JSONObject jsonObject = new JSONObject();
            for (int j = 0; j < columnas.length; j++) {
                try {
                    jsonObject.put(columnas[j], cursor.getString(cursor.getColumnIndex(columnas[j])));
                } catch (Exception e) {
                    Log.i("Mayor", e.toString());
                }
            }
            jsonArray.put(jsonObject);
            cursor.moveToNext();
        }
        db.close();
        return jsonArray;
    }
}

