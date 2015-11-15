package com.example.usuario.version4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

public class Sinformulados extends AppCompatActivity {

    NumberPicker fre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinformulados);
        fre= (NumberPicker)findViewById(R.id.numero);
        fre.setMaxValue(24);
        fre.setMinValue(1);
        fre.setWrapSelectorWheel(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sinformulados, menu);
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

    public void terminar(View v){
        Intent intento = new Intent(getApplicationContext(),Inicio.class);
        startActivity(intento);
    }
}
