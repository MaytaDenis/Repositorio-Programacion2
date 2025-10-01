package com.mycompany.herenciaempleados;

public abstract class Empleado {
    private String nombre;
    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    public abstract double CalcularSalarioMensual();
    @Override
    public String toString() {
        return "Empleado: " + this.nombre;
    }
    public String getNombre() {
        return nombre;
    }
}

