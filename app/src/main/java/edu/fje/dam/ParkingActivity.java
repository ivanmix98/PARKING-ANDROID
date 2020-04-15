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
        Button restCoche = findViewById(R.id.restCoche);
        Button restMoto = findViewById(R.id.restMoto);
        textNom.setText(nom);
        textCoche.setText(quantitatCoches);
        textMoto.setText(quantitatMotos);


        int numeroCoche = Integer.parseInt(quantitatCoches);
        int numeroMoto = Integer.parseInt(quantitatMotos);


        marcadorCoche.setNumeroPlazas(numeroCoche);
        parkingCoche.anadirObserverCoche(marcadorCoche);
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres()+"");


        marcadorMoto.setNumeroPlazas(numeroMoto);
        parkingMoto.anadirObserverCoche(marcadorMoto);
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres()+"");
        //circleMotos.setFill(Paint.valueOf("#2bff00")); <--- pone el semaforo en verde, por si usamos algo de eso

        restCoche.setEnabled(false);
        restMoto.setEnabled(false);


    }

    public void entrarCoche(View v){
        Button sumCoche = findViewById(R.id.sumCoche);
        Button resCoche = findViewById(R.id.restCoche);
        TextView textCoche = findViewById(R.id.textNumCoche);

        parkingCoche.anadirCoche(new Coche());
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres()+"");
        if(marcadorCoche.getNumeroPlazasLibres() < marcadorCoche.getNumeroPlazas()){
            resCoche.setEnabled(true);
        }
        if(marcadorCoche.getNumeroPlazasLibres() <= 0){
            //circleCoche.setFill(Paint.valueOf("Red"));
            sumCoche.setEnabled(false);

        }else {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
        }
    }

    public void salirCoche(View v){
        Button sumCoche = findViewById(R.id.sumCoche);
        Button resCoche = findViewById(R.id.restCoche);
        TextView textCoche = findViewById(R.id.textNumCoche);

        parkingCoche.salirCoche(0);
        textCoche.setText(marcadorCoche.getNumeroPlazasLibres()+"");
        if(marcadorCoche.getNumeroPlazasLibres() < marcadorCoche.getNumeroPlazas()){
            resCoche.setEnabled(true);
        }else if(marcadorCoche.getNumeroPlazasLibres() == marcadorCoche.getNumeroPlazas()){
            resCoche.setEnabled(false);
        }
        if(marcadorCoche.getNumeroPlazasLibres() >= 0){
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            sumCoche.setEnabled(true);

        }

        else {
            //circleCoche.setFill(Paint.valueOf("#Red"));
        }

    }

    public void entrarMoto(View v){
        Button sumMoto = findViewById(R.id.sumMoto);
        Button resMoto = findViewById(R.id.restMoto);
        TextView textMoto = findViewById(R.id.textNumMoto);

        parkingMoto.anadirCoche(new Coche());
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres()+"");
        if(marcadorMoto.getNumeroPlazasLibres() < marcadorMoto.getNumeroPlazas()){
            resMoto.setEnabled(true);
        }
        if(marcadorMoto.getNumeroPlazasLibres() <= 0){
            //circleCoche.setFill(Paint.valueOf("Red"));
            sumMoto.setEnabled(false);

        }else {
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
        }
    }

    public void salirMoto(View v){
        Button sumMoto = findViewById(R.id.sumMoto);
        Button resMoto = findViewById(R.id.restMoto);
        TextView textMoto = findViewById(R.id.textNumMoto);

        parkingMoto.salirCoche(0);
        textMoto.setText(marcadorMoto.getNumeroPlazasLibres()+"");
        if(marcadorMoto.getNumeroPlazasLibres() < marcadorMoto.getNumeroPlazas()){
            resMoto.setEnabled(true);
        }else if(marcadorMoto.getNumeroPlazasLibres() == marcadorMoto.getNumeroPlazas()){
            resMoto.setEnabled(false);
        }
        if(marcadorMoto.getNumeroPlazasLibres() >= 0){
            //circleCoche.setFill(Paint.valueOf("#2bff00"));
            sumMoto.setEnabled(true);
        }
        else {
            //circleCoche.setFill(Paint.valueOf("#Red"));
        }

    }
}
