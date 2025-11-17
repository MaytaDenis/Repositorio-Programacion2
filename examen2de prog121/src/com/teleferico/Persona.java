package com.teleferico;

public class Persona {
    private String nombre;
    private int edad;
    private float peso;
    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }
    public float getPeso() {
        return peso;
    }
    public int getEdad() {
        return edad;
    }
    public float getTarifa() {
        if (this.edad < 25 || this.edad > 60) {
            return 1.5f; 
        } else {
            return 3.0f;
        }
    }
}