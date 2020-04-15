package edu.fje.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParkingActivity extends AppCompatActivity {

    private Parking parkingCoche = new Parking();
    private Parking parkingMoto = new Parking();
    private Marcador marcadorCoche = new Marcador();
    private Marcador marcadorMoto = new Marcador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        //coger los mensajes del intent
        Intent intent = getIntent();
        String nom = intent.getStringExtra(MainActivity.NOM_PARKING);
        String quantitatCoches = intent.getStringExtra(MainActivity.QUANTITAT_COCHES);
        String quantitatMotos = intent.getStringExtra(MainActivity.QUANTITAT__MOTOS);

        //poner los mensajes del intent
        TextView textNom = findViewById(R.id.textNomParking);
        TextView textCoche = findViewById(R.id.textNumCoche);
        TextView textMoto = findViewById(R.id.textNumMoto);
        textNom.setText(nom);
        textCoche.setText(quantitatCoches);
        textMoto.setText(quantitatMotos);


    }

    public void entrarCoche(View v){
        final Button sumCoche = findViewById(R.id.sumCoche);
        final Button resCoche = findViewById(R.id.restCoche);
        final TextView textCoche = findViewById(R.id.textNumCoche);
        parkingCoche.anadirCoche(new Coche());
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres()+"");
        if(marcadorCoche.getNumeroPlazasLibres() < marcadorCoche.getNumeroPlazas()){
            resCoche.setEnabled(false);
        }
        if(marcadorCoche.getNumeroPlazasLibres() <= 0){
            sumCoche.setEnabled(true);

        }else {
            textCoche.setText("hola");
        }
    }
}
