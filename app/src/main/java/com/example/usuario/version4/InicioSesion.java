package com.example.usuario.version4;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    //private DBManager manager;
    private EditText txtusuario,txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        txtusuario = (EditText)findViewById(R.id.txtusuario);
        txtpassword = (EditText)findViewById(R.id.txtcontraseña);
        //manager = new DBManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio_sesion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registrar(View v){
        Intent intento= new Intent(getApplicationContext(),RegistroUsuario.class);
        startActivity(intento);
    }
    public void entrar (View v){
        int p = espaciosblancos();
        Toast.makeText(this, " HOLA  ", Toast.LENGTH_LONG).show();
    }

    public int espaciosblancos() {
        int r = 1;
        if ("".equals(txtusuario.getText().toString())) {
            r = 0;
            txtusuario.setHint("Debe ingresar su nombre de usuario");
            txtusuario.setHintTextColor(Color.parseColor("#51FF1218"));
        }
        if ("".equals(txtpassword.getText().toString())) {
            r = 0;
            txtpassword.setHint("Debe ingresar su contraseña");
            txtpassword.setHintTextColor(Color.parseColor("#51FF1218"));
        }
        return r;
    }
}
