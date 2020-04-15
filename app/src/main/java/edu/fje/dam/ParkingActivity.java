package edu.fje.dam;

import androidx.appcompat.app.AppCompatActivity;

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
    }

    public void entrarCoche(View v){
        final Button sumCoche = (Button) findViewById(R.id.sumCoche);
        final Button resCoche = (Button) findViewById(R.id.restCoche);
        final TextView textCoche = (TextView) findViewById(R.id.textNumCoche);
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
