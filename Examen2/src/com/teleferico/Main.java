package com.teleferico;

public class Main {
    public static void main(String[] args) {
        MiTeleferico miTeleferico = new MiTeleferico();
        miTeleferico.agregarCabina("Amarillo"); 
        miTeleferico.agregarCabina("Amarillo"); 
        Persona p1 = new Persona("Ana", 20, 60.0f);   
        Persona p2 = new Persona("Carlos", 35, 80.0f);
        Persona p3 = new Persona("Eva", 65, 75.0f);   

        System.out.println(" Inciso A");
        boolean abordado = miTeleferico.abordarPersona(p1, "Amarillo", 1);
        System.out.println("Ana de 20 años con peso 55kg abordo de Cabina 1 Amarillo : " + (abordado ? "si" : "no"));
        abordado = miTeleferico.abordarPersona(p2, "Amarillo", 1);
        System.out.println("deko de 26 años con peso 65kg abordo de Cabina 1 Amarillo : " + (abordado ? "si" : "no"));
        abordado = miTeleferico.abordarPersona(p2, "Amarillo", 1);
        System.out.println("juan de 65 años con peso 80kg abordo de Cabina 1 Amarillo : " + (abordado ? "si" : "no"));
        abordado = miTeleferico.abordarPersona(p2, "Amarillo", 1);
        System.out.println("Carlos de 35 años con peso de 76 kg abordo de Cabina 1 Amarillo: " + (abordado ? "si" : "no"));
        miTeleferico.agregarCabina("Rojo"); 
        abordado = miTeleferico.abordarPersona(p3, "Rojo", 1);
        System.out.println("Eva de 65 años con peso de 50kg abordo de  Cabina 1 Rojo: " + (abordado ? "si" : "no"));
        miTeleferico.agregarCabina("Verde"); 
        abordado = miTeleferico.abordarPersona(p1, "Verde", 1);
        System.out.println("sara de 25 años con peso de 50kg abordo de  Cabina 1 verde: " + (abordado ? "si" : "no"));
        System.out.println(" Inciso b");
        boolean cumplen = miTeleferico.verificarReglasDeAbordoGlobal();
        System.out.println("las cabinas cumplen las reglas de abordaje? " + (cumplen ? "si" : "no"));
        System.out.println(" Inciso c ");
        float ingresoTotal = miTeleferico.calcularIngresoTotalGlobal();
        System.out.printf("El ingreso total global es: %.2f bs", ingresoTotal);
        System.out.println("Inciso d");
        String lineaGanadora = miTeleferico.lineaConMasIngresoRegular();
        System.out.println(lineaGanadora);
    }
}