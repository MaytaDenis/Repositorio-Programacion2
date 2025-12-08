/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclinica;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Consultorio {
    private List<Medico> medicos;
    private List<Consulta> consultas;
    
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
    private final String FILE_MEDICOS = "medicos.json";
    private final String FILE_CONSULTAS = "consultas.json";
    public Consultorio() {
        this.medicos = cargarMedicos();
        this.consultas = cargarConsultas();
    }

    private List<Medico> cargarMedicos() {
        try (Reader reader = new FileReader(FILE_MEDICOS)) {
            Type listType = new TypeToken<ArrayList<Medico>>() {}.getType();
            List<Medico> loadedList = gson.fromJson(reader, listType);
            return loadedList != null ? loadedList : new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.out.println("INFO: Archivo " + FILE_MEDICOS + " no encontrado. Creando lista vacía.");
            return new ArrayList<>();
        } catch (IOException e) {
            System.err.println("ERROR al leer " + FILE_MEDICOS + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void guardarMedicos() {
        try (Writer writer = new FileWriter(FILE_MEDICOS)) {
            gson.toJson(medicos, writer);
        } catch (IOException e) {
            System.err.println("ERROR al escribir en " + FILE_MEDICOS + ": " + e.getMessage());
        }
    }
    private List<Consulta> cargarConsultas() {
         try (Reader reader = new FileReader(FILE_CONSULTAS)) {
            Type listType = new TypeToken<ArrayList<Consulta>>() {}.getType();
            List<Consulta> loadedList = gson.fromJson(reader, listType);
            return loadedList != null ? loadedList : new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.out.println("INFO: Archivo " + FILE_CONSULTAS + " no encontrado. Creando lista vacía.");
            return new ArrayList<>();
        } catch (IOException e) {
             System.err.println("ERROR al leer " + FILE_CONSULTAS + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    private void guardarConsultas() {
        try (Writer writer = new FileWriter(FILE_CONSULTAS)) {
            gson.toJson(consultas, writer);
        } catch (IOException e) {
            System.err.println("ERROR al escribir en " + FILE_CONSULTAS + ": " + e.getMessage());
        }
    }
    public void darDeAltaMedico(Medico m) {
        this.medicos.add(m);
        guardarMedicos(); 
    }
    public void darDeAltaConsulta(Consulta c) {
        this.consultas.add(c);
        guardarConsultas(); 
    }
    public boolean darDeBajaMedicoYConsultas(String nombreX, String apellidoY) {
        int idMedicoABorrar = -1;
      
        Iterator<Medico> itMed = medicos.iterator();
        while (itMed.hasNext()) {
            Medico m = itMed.next();
            if (m.getNombreMed().equalsIgnoreCase(nombreX) && m.getApellidoMed().equalsIgnoreCase(apellidoY)) {
                idMedicoABorrar = m.getIdMed();
                itMed.remove(); 
                break;
            }
        }
        
        if (idMedicoABorrar == -1) {
            System.out.println("Error: Médico " + nombreX + " " + apellidoY + " no encontrado.");
            return false;
        }
        int consultasEliminadas = 0;
        Iterator<Consulta> itCon = consultas.iterator();
        while (itCon.hasNext()) {
            Consulta c = itCon.next();
            if (c.getIdMed() == idMedicoABorrar) { 
                itCon.remove(); 
                consultasEliminadas++;
            }
        }
        guardarMedicos();
        guardarConsultas();
        System.out.println("Médico eliminado. Total de consultas eliminadas: " + consultasEliminadas);
        return true;
    }
    public int cambiarDiaConsultasFestivas(int nuevoDia) {
        int consultasModificadas = 0;
        
        for (Consulta c : consultas) {
            boolean esNavidad = c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre");
            boolean esAnioNuevo = c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero");
            
            if (esNavidad || esAnioNuevo) {
                c.setDia(nuevoDia); 
                consultasModificadas++;
            }
        }
        
        guardarConsultas();
        return consultasModificadas;
    }
    public void mostrarPacientesPorFecha(int dia, String mes) {
        System.out.println("Pacientes atendidos el " + dia + " de " + mes + " ");
        boolean found = false;
        for (Consulta c : consultas) {
            if (c.getDia() == dia && c.getMes().equalsIgnoreCase(mes)) {
                System.out.println("- " + c.getNombrePaciente() + " " + c.getApellidoPaciente() + " (ID Consulta: " + c.getId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron consultas en esa fecha.");
        }
    }
    public void mostrarEstado() {
        System.out.println(" ESTADO ACTUAL");
        System.out.println("Total de Medicos en memoria: " + medicos.size());
        medicos.forEach(System.out::println);
        System.out.println("Total de Consultas en memoria: " + consultas.size());
        consultas.forEach(System.out::println);
        System.out.println("");
    }
}