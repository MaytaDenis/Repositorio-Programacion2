package com.teleferico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiTeleferico {
    private List<Linea> lineas; 
    private float cantidadIngresos; 
    private static final String[] COLORES_VALIDOS = {"Amarillo", "Rojo", "Verde"};

   
    public MiTeleferico() {
        this.lineas = new ArrayList<>();
        this.cantidadIngresos = 0.0f;
        for (String color : COLORES_VALIDOS) {
            this.lineas.add(new Linea(color));
        }
    }
    private Linea buscarLinea(String color) {
        for (Linea l : lineas) {
            if (l.getColor().equalsIgnoreCase(color)) {
                return l;
            }
        }
        return null;
    }
    public void agregarPersonaFila(Persona p, String lineaColor) {
        Linea linea = buscarLinea(lineaColor);
        if (linea != null) {
            linea.agregarPersonaFila(p);
        } else {
            System.out.println("Error: La línea " + lineaColor + " no existe.");
        }
    }

    public void agregarCabina(String lineaColor) {
        Linea linea = buscarLinea(lineaColor);
        if (linea != null) {
            linea.agregarCabina(linea.getCabinas().size() + 1);
        } else {
            System.out.println("Error: La línea " + lineaColor + " no existe.");
        }
    }

    public boolean abordarPersona(Persona p, String lineaColor, int nroCabina) {
        Linea linea = buscarLinea(lineaColor);
        if (linea == null) return false;
        
        for (Cabina cabina : linea.getCabinas()) {
            if (cabina.getNroCabina() == nroCabina) {
                return cabina.agregarPersona(p); 
            }
        }
        return false;
    }
    public boolean verificarReglasDeAbordoGlobal() {
        for (Linea linea : lineas) {
            if (!linea.todasCabinasCumplenReglas()) {
                return false;
            }
        }
        return true;
    }

    public float calcularIngresoTotalGlobal() {
        float total = 0.0f;
        for (Linea linea : lineas) {
            total += linea.calcularIngresoTotal();
        }
        this.cantidadIngresos = total; 
        return total;
    }
    public String lineaConMasIngresoRegular() {
        String lineaGanadora = "N/A";
        float maxIngresoRegular = -1.0f;

        for (Linea linea : lineas) {
            float ingresoRegularActual = linea.calcularIngresoRegular();
            if (ingresoRegularActual > maxIngresoRegular) {
                maxIngresoRegular = ingresoRegularActual;
                lineaGanadora = linea.getColor();
            }
        }
        
        if (maxIngresoRegular > 0) {
            return "La linea con mas ingreso solo con tarifa regular (" + maxIngresoRegular + " bs) es: " + lineaGanadora;
        } else {
            return "No hay ingresos por tarifa regular registrados.";
        }
    }
}