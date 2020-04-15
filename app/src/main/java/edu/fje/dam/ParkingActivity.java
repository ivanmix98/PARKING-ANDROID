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
    private String nom, quantitatCoches, quantitatMotos;
    private TextView textNom, textCoche, textMoto, disponibilidadCoche, disponibilidadMoto;
    private Button restCoche, restMoto, sumCoche, sumMoto;
    private int numeroCoche, numeroMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        textNom = findViewById(R.id.textNomParking);
        textCoche = findViewById(R.id.textNumCoche);
        textMoto = findViewById(R.id.textNumMoto);
        restCoche = findViewById(R.id.restCoche);
        restMoto = findViewById(R.id.restMoto);
        sumCoche = findViewById(R.id.sumCoche);
        sumMoto = findViewById(R.id.sumMoto);
        disponibilidadCoche = findViewById(R.id.disponibilidadCoche);
        disponibilidadMoto = findViewById(R.id.disponibilidadMoto);
        //coger los mensajes del intent y ponerlos
        Intent intent = getIntent();
        nom = intent.getStringExtra(MainActivity.NOM_PARKING);
        quantitatCoches = intent.getStringExtra(MainActivity.QUANTITAT_COCHES);
        quantitatMotos = intent.getStringExtra(MainActivity.QUANTITAT__MOTOS);
        textNom.setText(nom);
        textCoche.setText(quantitatCoches);
        textMoto.setText(quantitatMotos);

        //init
        numeroCoche = Integer.parseInt(quantitatCoches);
        numeroMoto = Integer.parseInt(quantitatMotos);

        marcadorCoche.setNumeroPlazas(numeroCoche);
        parkingCoche.anadirObserverCoche(marcadorCoche);
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres() + "");

        marcadorMoto.setNumeroPlazas(numeroMoto);
        parkingMoto.anadirObserverCoche(marcadorMoto);
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres() + "");

        restCoche.setEnabled(false);
        restMoto.setEnabled(false);

    }

    public void entrarCoche(View v) {

        parkingCoche.anadirCoche(new Coche());
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres() + "");
        if (marcadorCoche.getNumeroPlazasLibres() < marcadorCoche.getNumeroPlazas()) {
            restCoche.setEnabled(true);
        }
        if (marcadorCoche.getNumeroPlazasLibres() <= 0) {
            //circleCoche.setFill(Paint.valueOf("Red"));
            disponibilidadCoche.setText("COMPLET");
            sumCoche.setEnabled(false);

        } else {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            disponibilidadCoche.setText("Disponible");
        }
    }

    public void salirCoche(View v) {

        parkingCoche.salirCoche(0);
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres() + "");
        if (marcadorCoche.getNumeroPlazasLibres() < marcadorCoche.getNumeroPlazas()) {
            restCoche.setEnabled(true);
        } else if (marcadorCoche.getNumeroPlazasLibres() == marcadorCoche.getNumeroPlazas()) {
            restCoche.setEnabled(false);
        }
        if (marcadorCoche.getNumeroPlazasLibres() >= 0) {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            disponibilidadCoche.setText("Disponible");
            sumCoche.setEnabled(true);
        } else {
            //circleCoche.setFill(Paint.valueOf("#Red"));
            disponibilidadCoche.setText("COMPLET");
        }

    }

    public void entrarMoto(View v) {
        parkingMoto.anadirCoche(new Coche());
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres() + "");
        if (marcadorMoto.getNumeroPlazasLibres() < marcadorMoto.getNumeroPlazas()) {
            restMoto.setEnabled(true);
        }
        if (marcadorMoto.getNumeroPlazasLibres() <= 0) {
            //circleCoche.setFill(Paint.valueOf("Red"));
            disponibilidadMoto.setText("COMPLET");
            sumMoto.setEnabled(false);

        } else {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            disponibilidadMoto.setText("Disponible");
        }
    }

    public void salirMoto(View v) {

        parkingMoto.salirCoche(0);
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres() + "");
        if (marcadorMoto.getNumeroPlazasLibres() < marcadorMoto.getNumeroPlazas()) {
            restMoto.setEnabled(true);
        } else if (marcadorMoto.getNumeroPlazasLibres() == marcadorMoto.getNumeroPlazas()) {
            restMoto.setEnabled(false);
        }
        if (marcadorMoto.getNumeroPlazasLibres() >= 0) {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            disponibilidadMoto.setText("Disponible");
            sumMoto.setEnabled(true);
        } else {
            //circleCoche.setFill(Paint.valueOf("#Red"));
            disponibilidadMoto.setText("COMPLET");
        }

    }
}
