/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclinica;
public class Consulta {
    private int id;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed; 
    private int dia;
    private String mes;
    private int anio;

    public Consulta(int id, String nombreP, String apellidoP, int idMed, int dia, String mes, int anio) {
        this.id = id;
        this.nombrePaciente = nombreP;
        this.apellidoPaciente = apellidoP;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public Consulta() {}
    public int getId() { return id; }
    public int getIdMed() { return idMed; }
    public int getDia() { return dia; }
    public String getMes() { return mes; }
    public String getNombrePaciente() { return nombrePaciente; }
    public String getApellidoPaciente() { return apellidoPaciente; }
    public void setDia(int dia) { this.dia = dia; }

    @Override
    public String toString() {
        return "ID: " + id + ", Paciente: " + nombrePaciente + " " + apellidoPaciente + 
               ", Medico ID: " + idMed + ", Fecha: " + dia + "-" + mes + "-" + anio;
    }
}
