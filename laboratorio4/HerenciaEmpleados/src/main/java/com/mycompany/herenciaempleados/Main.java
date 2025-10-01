package com.mycompany.herenciaempleados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        String nombre;
        double salario;
        double horas;
        double tarifa;
        System.out.println("datos de 3 empleados a tiempo completo");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre del empleado a tiempo completo " + (i + 1) + ": ");
            nombre = scanner.nextLine();
            System.out.print("Salario anual: ");
            salario = scanner.nextDouble();
            scanner.nextLine(); 
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salario);
        }
        System.out.println("datos de 2 empleados de tiempo horario ");
        for (int i = 3; i < 5; i++) {
            System.out.print("Nombre del empleado a tiempo horario " + (i - 2) + ": ");
            nombre = scanner.nextLine();
            System.out.print("Horas trabajadas: ");
            horas = scanner.nextDouble();
            System.out.print("Tarifa por hora: ");
            tarifa = scanner.nextDouble();
            scanner.nextLine(); 
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }
        
        System.out.println("los salarios son");
        for (Empleado empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre() + 
                               ", Salario Mensual: bs" + empleado.CalcularSalarioMensual());
        }

        scanner.close();
    }
}