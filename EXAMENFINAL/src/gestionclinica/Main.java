package gestionclinica;

import java.util.Scanner;
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Consultorio consultorio = new Consultorio();

    public static void main(String[] args) {
        System.out.println("GESTOR DE ARCHIVOS DE LA CLINICA");
        consultorio.mostrarEstado(); 
        mostrarMenu();
    }
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println(" Entrada invalida");
            }
        }
    }
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
    private static void manejarAlta() {
        System.out.println("Dar de Alta");
        int numMedicos = leerEntero("Cuantos médicos desea dar de alta");
        if (numMedicos < 3) numMedicos = 3;

        for (int i = 0; i < numMedicos; i++) {
            System.out.println("Ingresando Medico #" + (i + 1) + ":");
            int idMed = leerEntero("  ID del Medico: ");
            String nombreMed = leerTexto("  Nombre del Medico: ");
            String apellidoMed = leerTexto("  Apellido del Medico: ");
            int aniosExperiencia = leerEntero("  Anios de Experiencia: ");

            Medico nuevoMedico = new Medico(idMed, nombreMed, apellidoMed, aniosExperiencia);
            consultorio.darDeAltaMedico(nuevoMedico); 
            System.out.println("Medico dado de alta");
        }
        int numConsultas = leerEntero("Cuantas consultas desea dar de alta");
        if (numConsultas < 9) numConsultas = 9;

        for (int i = 0; i < numConsultas; i++) {
            System.out.println(" Ingresando Consulta #" + (i + 1) + ":");
            int id = leerEntero("  CI/ID de la Consulta: ");
            String nombreP = leerTexto("  Nombre del Paciente: ");
            String apellidoP = leerTexto("  Apellido del Paciente: ");
            int idMed = leerEntero("  ID del Medico a cargo: "); 
            int dia = leerEntero("  Día (ej. 25): ");
            String mes = leerTexto("  Mes (ej. Diciembre): ");
            int anio = leerEntero("  Año (ej. 2025): ");

            Consulta nuevaConsulta = new Consulta(id, nombreP, apellidoP, idMed, dia, mes, anio);
            consultorio.darDeAltaConsulta(nuevaConsulta); 
            System.out.println("Consulta dada de alta ");
        }
        consultorio.mostrarEstado();
    }
    private static void manejarBaja() {
        System.out.println("baja de medico y consultas");
        
        String nombreX = leerTexto("Ingrese el Nombre del Medico a dar de baja: ");
        String apellidoY = leerTexto("Ingrese el Apellido del Medico a dar de baja: ");
        if (consultorio.darDeBajaMedicoYConsultas(nombreX, apellidoY)) {
            System.out.println("se dio de baja");
        } else {
        }
        consultorio.mostrarEstado();
    }
    private static void manejarCambioDia() {
        System.out.println("cambiar las fechas festivas agendadas");
        int nuevoDia = leerEntero("Ingrese el nuevo dIa  de la consulta para fechas festivas: ");
        int modificadas = consultorio.cambiarDiaConsultasFestivas(nuevoDia);
        System.out.println("Resultado: " + modificadas + " consultas festivas fueron cambiadas al dia " + nuevoDia + ".");
        consultorio.mostrarEstado();
    }
    private static void manejarOpcional() {
        System.out.println("Atendidos en sus cumpleanios");
        
        int dia = leerEntero("Ingrese el dia de la fecha a buscar: ");
        String mes = leerTexto("Ingrese el Mes de la fecha a buscar: ");
        
        consultorio.mostrarPacientesPorFecha(dia, mes);
    }
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1.Dar de Alta Medicos y Consultas");
            System.out.println("2.Dar de Baja Medico y Consultas");
            System.out.println("3.Reagendar dias festivos");
            System.out.println("4.Buscar Pacientes por cumpleanios ");
            System.out.println("5.Ver Estado Actual de los Archivos");
            System.out.println("0.salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    manejarAlta();
                    break;
                case 2:
                    manejarBaja();
                    break;
                case 3:
                    manejarCambioDia();
                    break;
                case 4:
                    manejarOpcional();
                    break;
                case 5:
                    consultorio.mostrarEstado();
                    break;
                case 0:
                    System.out.println("Guardando datos y cerrando el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}