package edu.fje.dam;

import java.util.ArrayList;

public class Parking {
    private ArrayList<Coche> coches = new ArrayList<Coche>();
    private ArrayList<Moto> motos = new ArrayList<Moto>();
    private ArrayList<AutoListener> listenersCoche = new ArrayList<>();

    public Parking() {
    }

    public void anadirCoche(Coche coche){
        this.coches.add(coche);
        this.avisaCocheEntrado(this.coches.size());
    }

    public void salirCoche(int coche){
        this.coches.remove(coche);
        this.avisaCocheEntrado(this.coches.size());
    }



    public void avisaCocheEntrado(int numeroCoches){

        AutoEntratEvent cocheEntratEvent = new AutoEntratEvent(this,numeroCoches);

        for (AutoListener listener: this.listenersCoche) {
            listener.cocheEntra(cocheEntratEvent);
        }
    }


    public void anadirObserverCoche(AutoListener cl){
        this.listenersCoche.add(cl);
    }

    public void eliminarObserverCoche(AutoListener cl){
        this.listenersCoche.remove(cl);
    }







    //GETTERS && SETTERS


    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public ArrayList<Moto> getMotos() {
        return motos;
    }

    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }
}
