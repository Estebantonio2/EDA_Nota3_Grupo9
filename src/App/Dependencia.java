/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import TDA.*;

/**
 *
 * @author esteb
 */
public class Dependencia {
    private String nombre;
    private Cola p1, p2, p3;
    private Expediente ultimoExp;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.p1 = new Cola<Expediente>();
        this.p2 = new Cola<Expediente>();
        this.p3 = new Cola<Expediente>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cola getP1() {
        return p1;
    }

    public void setP1(Cola p1) {
        this.p1 = p1;
    }

    public Cola getP2() {
        return p2;
    }

    public void setP2(Cola p2) {
        this.p2 = p2;
    }

    public Cola getP3() {
        return p3;
    }

    public void setP3(Cola p3) {
        this.p3 = p3;
    }

    public Expediente getUltimoExp() {
        return ultimoExp;
    }

    public void setUltimoExp(Expediente ultimoExp) {
        this.ultimoExp = ultimoExp;
    }
    
    public void agregarExpediente(Expediente expediente){
        int prioridad = expediente.getPrioridad();
        if(prioridad == 1){
            p1.encolar(expediente);
            ultimoExp = (Expediente) p1.frente();
        }else if(prioridad == 2){
            p2.encolar(expediente);
            ultimoExp = (Expediente) p2.frente();
        }else if(prioridad == 3){
            p3.encolar(expediente);
            ultimoExp = (Expediente) p3.frente();
        }else{
            // interfaz grafica
        }
    }
    
    public void eliminarExpediente(String id){
        Cola aux = new Cola<Expediente>();
        while(!p1.esVacia()){
            Expediente exp =(Expediente) p1.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }
        }
        p1 = aux;
        aux = new Cola<Expediente>();
        while(!p2.esVacia()){
            Expediente exp =(Expediente) p2.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }
        }
        p2 = aux;
        aux = new Cola<Expediente>();
        while(!p3.esVacia()){
            Expediente exp =(Expediente) p3.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }
        }
        p3 = aux;
        aux = new Cola<Expediente>();
    }
    
    public Expediente entregarExpediente(){
        Expediente exp;
        if(!p1.esVacia()){
            exp = (Expediente) p1.desencolar();
            return exp;
        }else if(!p2.esVacia()){
            exp = (Expediente) p2.desencolar();
            return exp;
        }else if(!p3.esVacia()){
            exp = (Expediente) p3.desencolar();
            return exp;
        }else{
            return null; // interfaz grafica
        }
    }
    
}
