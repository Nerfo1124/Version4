package com.example.usuario.version4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Conformula extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    public SeekBar barra, barra2;
    public TextView iz,de;
    public int uno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conformula);
        barra = (SeekBar)findViewById(R.id.barra);
        barra.setOnSeekBarChangeListener(this);
        barra2 = (SeekBar)findViewById(R.id.barra2);
        barra2.setOnSeekBarChangeListener (this);
        iz = (TextView)findViewById(R.id.lblizq);
        de = (TextView)findViewById(R.id.lblder);
        Bundle bundle = getIntent().getExtras();
        String[] dato=bundle.getStringArray("1 2 3");
        Toast.makeText(this,dato[1],Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_conformula, menu);
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.equals(barra)){
            iz.setText(""+progress);
        }else {
            de.setText("Hola");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void siguiente(View v){
        Intent intento = new Intent(getApplicationContext(),Sinformulados.class);
        startActivity(intento);
    }

    public void mas(View v){
        barra.setProgress(barra.getProgress()+1);
    }
}
