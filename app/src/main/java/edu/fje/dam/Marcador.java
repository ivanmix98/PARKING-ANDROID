package edu.fje.dam;

import java.util.EventObject;

public class Marcador implements AutoListener {

    private int numeroPlazas;
    private int numeroPlazasOcupadas = 0;
    private int numeroPlazasLibres;

    public Marcador() {
    }

    @Override
    public void cocheEntra(AutoEntratEvent autoEntratEvent) {
        this.numeroPlazasOcupadas = autoEntratEvent.getNumCoches();

        this.numeroPlazasLibres = numeroPlazas - numeroPlazasOcupadas;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public int getNumeroPlazasLibres() {
        return numeroPlazasLibres;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        this.numeroPlazasLibres =  this.numeroPlazas;

    }

    public int getNumeroPlazasOcupadas() {
        return numeroPlazasOcupadas;
    }

    public void setNumeroPlazasOcupadas(int numeroPlazasOcupadas) {
        this.numeroPlazasOcupadas = numeroPlazasOcupadas;
    }

    public void setNumeroPlazasLibres(int numeroPlazasLibres) {
        this.numeroPlazasLibres = numeroPlazasLibres;
    }
}
