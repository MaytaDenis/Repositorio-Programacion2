package com.mycompany.herenciaempleados;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioAnual;
    public EmpleadoTiempoCompleto(String nombre, double salarioAnual) {
        super(nombre); 
        this.salarioAnual = salarioAnual;
    }
    @Override
    public double CalcularSalarioMensual() {
        return this.salarioAnual / 12;
    }
    @Override
    public String toString() {
        return super.toString() + ", Salario Anual: bs" + this.salarioAnual;
    }
}