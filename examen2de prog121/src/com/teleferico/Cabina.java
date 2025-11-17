package com.teleferico;

import java.util.ArrayList;
import java.util.List;

public class Cabina {
    private int nroCabina;
    private List<Persona> personasAbordo; 
    private float pesoPersona; 
    public static final int MAX_PERSONAS = 10;
    public static final float MAX_PESO_KG = 850.0f;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new ArrayList<>(); 
        this.pesoPersona = 0.0f; 
    }
    public boolean agregarPersona(Persona p) {
        if (personasAbordo.size() < MAX_PERSONAS && (this.pesoPersona + p.getPeso()) <= MAX_PESO_KG) {
            personasAbordo.add(p);
            this.pesoPersona += p.getPeso();
            return true;
        }
        return false;
    }
    public boolean cumpleReglasAbordo() {
        return this.personasAbordo.size() <= MAX_PERSONAS && this.pesoPersona <= MAX_PESO_KG;
    }
    public float calcularIngreso() {
        float ingresoTotal = 0.0f;
        for (Persona p : personasAbordo) {
            ingresoTotal += p.getTarifa();
        }
        return ingresoTotal;
    }
    public List<Persona> getPersonasAbordo() {
        return personasAbordo;
    }
    
    public int getNroCabina() {
        return nroCabina;
    }
}