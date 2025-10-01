package com.mycompany.herenciaempleados;

public class EmpleadoTiempoHorario extends Empleado {
    
    private double horasTrabajadas;
    private double tarifaPorHora;
    public EmpleadoTiempoHorario(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre); 
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    @Override
    public double CalcularSalarioMensual() {
        return this.horasTrabajadas * this.tarifaPorHora;
    }
    @Override
    public String toString() {
        return super.toString() + ", Horas Trabajadas: " + this.horasTrabajadas + ", Tarifa: bs" + this.tarifaPorHora;
    }
}
