package edu.fje.dam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Inicializar los campos a rellenar
    private EditText Nom, QuantitatCoches, QuantitatMotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar los campos
        Nom = (EditText) findViewById(R.id.nom);
        QuantitatCoches = (EditText) findViewById(R.id.coches);
        QuantitatMotos = (EditText) findViewById(R.id.motos);
    }

    //metodo boton

    public static final String NOM_PARKING = "nom del parking:";
    public static final String QUANTITAT_COCHES = "Quantitat coches:";
    public static final String QUANTITAT__MOTOS = "Quantitat motos:";
    public void Crear(View v){
        if(Nom.getText().toString().isEmpty()){
            Toast.makeText(this, "Escriu el nom del parking", Toast.LENGTH_SHORT).show();
        }else {
            if(QuantitatCoches.getText().toString().isEmpty()){
                Toast.makeText(this, "Indica la quantitat de coches", Toast.LENGTH_SHORT).show();
            }else{
                if(QuantitatMotos.getText().toString().isEmpty()){
                    Toast.makeText(this, "Indica la quantitat de motos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "PARKING CREADO AH NO PARÁ WACHO FALTA QUE GUARDE LOS DATOS Y DEMÁS", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ParkingActivity.class);
                    String nom = Nom.getText().toString();
                    String quantitatCoches = QuantitatCoches.getText().toString();
                    String quantitatMotos = QuantitatMotos.getText().toString();
                    intent.putExtra(NOM_PARKING, nom);
                    intent.putExtra(QUANTITAT_COCHES, quantitatCoches);
                    intent.putExtra(QUANTITAT__MOTOS, quantitatMotos);
                    startActivity(intent);
                }
            }
        }
    }
}
