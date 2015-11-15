
package com.example.usuario.version4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by Usuario on 19/09/2015.
 */
public class DBManager {

    public static final String TABLE_NAME="USUARIO";
    public static final String usu_nombreusuario="usu_nombreusuario";
    public static final String usu_nombre="usu_nombre";
    public static final String usu_apellidos="usu_apellidos";
    public static final String usu_fecha="usu_fecha";
    public static final String usu_sexo="usu_sexo";
    public static final String usu_pregunta="usu_pregunta";
    public static final String usu_respuesta="usu_respuesta";
    public static final String usu_contraseña="usu_contraseña";
    public static final String usu_formula="usu_formula";

    public static final  String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + usu_nombreusuario + " text primary key, "
            + usu_nombre + " text not null, "
            + usu_apellidos + " text not null, "
            + usu_fecha + " date not null, "
            + usu_sexo + " text not null, "
            + usu_pregunta + " text not null, "
            + usu_respuesta + " text not null, "
            + usu_contraseña + " text not null, "
            + usu_formula +  " boolean not null )";

    private DBhelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context){
        try {
            helper = new DBhelper(context);
            db = helper.getWritableDatabase();
        }catch (Exception ex){
            Toast.makeText(context," Erro:"+ ex.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    public  void  insertar(String nombreU,String nombre, String apellido, String fecha, String sexo,String pregunta, String respuesta ,String contraseña, boolean formula){
        db.insert(TABLE_NAME,null,generarContentValues(nombreU,nombre,apellido,fecha,sexo,pregunta,respuesta,contraseña,formula));
    }

    private ContentValues generarContentValues(String nombreU,String nombre, String apellido, String fecha, String sexo,String pregunta, String respuesta, String contraseña, boolean formula){
        ContentValues valores = new ContentValues();
        valores.put(usu_nombreusuario,nombreU);
        valores.put(usu_nombre, nombre);
        valores.put(usu_apellidos,apellido);
        valores.put(usu_fecha,fecha);
        valores.put(usu_sexo,sexo);
        valores.put(usu_pregunta,pregunta);
        valores.put(usu_respuesta,respuesta);
        valores.put(usu_contraseña,contraseña);
        valores.put(usu_formula,formula);
        return  valores;
    }

    /*
    public void eliminar (String nombre){
        db.delete(TABLE_NAME, con_nombre + "=?", new String[]{nombre});
    }

    public void modificartelefono (String nombre, String tel){
        db.update(TABLE_NAME, generarContentValues(nombre, tel), con_nombre + "=?", new String[]{nombre});
    }
    */

    public Cursor cargarcursorcontactos(){
        String[] columnas = new String[]{usu_nombreusuario,usu_nombre,usu_apellidos,usu_fecha,usu_sexo,usu_pregunta,usu_respuesta,usu_contraseña,usu_formula};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }
}
