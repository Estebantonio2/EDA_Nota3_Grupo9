/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author esteb
 */
public class Expediente {
    private String id, asunto, documentoRef, nombreDep;
    private Interesado interesado;
    private int prioridad;
    private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;

    public Expediente() {
        this.tiempoInicio = LocalDateTime.now();
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocumentoRef() {
        return documentoRef;
    }

    public void setDocumentoRef(String documentoRef) {
        this.documentoRef = documentoRef;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }
    
    public LocalDateTime getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(LocalDateTime tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public LocalDateTime getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(LocalDateTime tiempoFin) {
        this.tiempoFin = tiempoFin;
    }
    
    public String getFechaInicio(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaInicio = this.tiempoInicio.format(formato);
        return fechaInicio;
    }
    
    public String getHoraInicio(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        String horaInicio = this.tiempoInicio.format(formato);
        return horaInicio;
    }
    
    public void finExpediente(){
        this.tiempoFin = LocalDateTime.now();
    }
    
    public String getFechaFin(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFin = this.tiempoFin.format(formato);
        return fechaFin;
    }
    
    public String getHoraFin(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        String horaFin = this.tiempoFin.format(formato);
        return horaFin;
    }
}
