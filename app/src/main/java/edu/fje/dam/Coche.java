package edu.fje.dam;

import java.io.Serializable;

public class Coche implements Serializable {

    private String matricula;
    private String marca;
    private String color;

    public Coche() {
    }



    public void setMarca(String marca) {
        this.marca = marca;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getMarca() {
        return marca;
    }


    public String getMatricula() {
        return matricula;
    }
}
