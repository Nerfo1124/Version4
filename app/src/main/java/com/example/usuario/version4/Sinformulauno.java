package com.example.usuario.version4;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sinformulauno extends AppCompatActivity {

    EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinformulauno);
        texto = (EditText)findViewById(R.id.txttexto);
        Bundle bundle = getIntent().getExtras();
        String[] dato=bundle.getStringArray("1 2 3");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sinformulauno, menu);
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

    public void siguiente (View v){
        Intent intento = new Intent(getApplicationContext(),Sinformulados.class);
        startActivity(intento);
    }
    public void mas(View v){
        float t= texto.getTextSize();
        Toast.makeText(this, "tamaño " + t, Toast.LENGTH_LONG).show();
        texto.setTextSize(t + 2);
    }

    public void menos(View v){
        float t= texto.getTextSize();
        Toast.makeText(this,"tamaño "+t,Toast.LENGTH_LONG).show();
        texto.setTextSize(t-2);
    }
}
