/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import TDA.*;
import java.time.LocalTime;

/**
 *
 * @author esteb
 */
public class GestionExpediente {
    private int cantidad;
    private Lista expedientes;
    
    public GestionExpediente(){
        expedientes = new Lista<Expediente>();
        cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Lista getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(Lista expedientes) {
        this.expedientes = expedientes;
    }
    
    public void agregarExpediente(Expediente expediente){
        this.expedientes.agregar(expediente);
        cantidad++;
    }
    
    public void eliminarExpediente(String id){
        for(int i = 1; i <= this.expedientes.longitud(); i++){
            Expediente exp = (Expediente) this.expedientes.iesimo(i);
            if(exp.getId().equalsIgnoreCase(id)){
                this.expedientes.eliminar(exp);
                cantidad--;
                break;
            }
        }
    }
    
    public Expediente[] ordenarPrioridad(){
        Expediente[] resultado = new Expediente[cantidad];
        int x = 0;
        for(int i = 1; i <= this.expedientes.longitud(); i++){
            Expediente exp = (Expediente) this.expedientes.iesimo(i);
            if(exp.getPrioridad() == 1){
                resultado[x] = exp;
                x++;
            }
        }
        for(int i = 1; i <= this.expedientes.longitud(); i++){
            Expediente exp = (Expediente) this.expedientes.iesimo(i);
            if(exp.getPrioridad() == 2){
                resultado[x] = exp;
                x++;
            }
        }
        for(int i = 1; i <= this.expedientes.longitud(); i++){
            Expediente exp = (Expediente) this.expedientes.iesimo(i);
            if(exp.getPrioridad() == 3){
                resultado[x] = exp;
                x++;
            }
        }
        return resultado;
    }
    
    public Expediente[] ordenarAntiguedad(){
        Expediente[] resultado = new Expediente[cantidad];
        for(int i = 0; i < cantidad; i++){
            resultado[i] = (Expediente) this.expedientes.iesimo(i+1);
        }
        
        for(int i = 0; i < cantidad-1; i++){
            for(int j = 0; j < cantidad-1-i; j++){
                LocalTime tiempo1 = resultado[j].getTiempoInicio().toLocalTime();
                LocalTime tiempo2 = resultado[j+1].getTiempoInicio().toLocalTime();
                if(tiempo1.isAfter(tiempo2)){
                    Expediente aux = resultado[j];
                    resultado[j] = resultado[j+1];
                    resultado[j+1] = aux;                    
                }
            }
        }
        return resultado;
    }
    
}
