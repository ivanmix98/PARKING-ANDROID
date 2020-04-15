package edu.fje.dam;

import java.util.EventObject;

public class AutoEntratEvent extends EventObject {

    private int numeroCoches;

    public AutoEntratEvent(Object source,int numeroCoches) {
        super(source);
        this.numeroCoches = numeroCoches;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public int getNumCoches() {
        return this.numeroCoches;
    }
}
