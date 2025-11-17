package com.teleferico;

import java.util.ArrayList;
import java.util.List;

public class Linea {
    
    private String color;
    private List<Persona> filaPersonas;
    private List<Cabina> cabinas;      
    private int cantidadCabinas;
    public Linea(String color) {
        this.color = color;
        this.filaPersonas = new ArrayList<>();
        this.cabinas = new ArrayList<>();
        this.cantidadCabinas = 0;
    }
    public List<Cabina> getCabinas() {
        return cabinas;
    }
    public void agregarPersonaFila(Persona p) {
        this.filaPersonas.add(p);
    }
    public void agregarCabina(int nroCabina) {
        this.cabinas.add(new Cabina(nroCabina));
        this.cantidadCabinas++;
    }
    public boolean agregarPersonaCabina(Persona p) {
        for (Cabina cabina : cabinas) {
            if (cabina.agregarPersona(p)) {
                return true; 
            }
        }
        return false; 
    }
    public boolean todasCabinasCumplenReglas() {
        for (Cabina cabina : cabinas) {
            if (!cabina.cumpleReglasAbordo()) {
                return false;
            }
        }
        return true;
    }
    public float calcularIngresoTotal() {
        float total = 0.0f;
        for (Cabina cabina : cabinas) {
            total += cabina.calcularIngreso();
        }
        return total;
    }
    public float calcularIngresoRegular() {
        float ingresoRegular = 0.0f;
        for (Cabina cabina : cabinas) {
            for (Persona p : cabina.getPersonasAbordo()) {
                if (p.getTarifa() == 3.0f) { 
                    ingresoRegular += 3.0f;
                }
            }
        }
        return ingresoRegular;
    }
    public String getColor() {
        return color;
    }
}