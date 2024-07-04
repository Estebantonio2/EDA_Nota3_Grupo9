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
    private String nombre, encargado;
    private Cola p1, p2, p3;
    private Expediente ultimoExp;

    public Dependencia() {
        this.p1 = new Cola<Expediente>();
        this.p2 = new Cola<Expediente>();
        this.p3 = new Cola<Expediente>();
    }

    public Dependencia(String nombre, String encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
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

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
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
    
    public Expediente extraerExpediente(String id){
        Cola aux = new Cola<Expediente>();
        Expediente expAux = new Expediente();
        while(!p1.esVacia()){
            Expediente exp =(Expediente) p1.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }else{
                expAux = exp;
            }
        }
        p1 = aux;
        aux = new Cola<Expediente>();
        while(!p2.esVacia()){
            Expediente exp =(Expediente) p2.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }else{
                expAux = exp;
            }
        }
        p2 = aux;
        aux = new Cola<Expediente>();
        while(!p3.esVacia()){
            Expediente exp =(Expediente) p3.desencolar();
            if(!exp.getId().equalsIgnoreCase(id)){
                aux.encolar(exp);
            }else{
                expAux = exp;
            }
        }
        p3 = aux;
        aux = new Cola<Expediente>();
        return expAux;
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
    
    public boolean estaVacia(){
        if(!p1.esVacia() || !p2.esVacia() || !p3.esVacia()){
            return false;
        }else{
            return true;
        }
    }
    
    public void mostrarColas(){
        Cola<Expediente> aux1 = p1.clonar();
        Cola<Expediente> aux2 = p2.clonar();
        Cola<Expediente> aux3 = p3.clonar();
        System.out.println(this.nombre);
        System.out.print("prioridad1: ");
        while(!aux1.esVacia()){
            Expediente e = aux1.desencolar();
            System.out.print(e.getId() + "\t");
        }
        System.out.println("");
        System.out.print("prioridad2: ");
        while(!aux2.esVacia()){
            Expediente e = aux2.desencolar();
            System.out.print(e.getId() + "\t");
        }
        System.out.println("");
        System.out.print("prioridad3: ");
        while(!aux3.esVacia()){
            Expediente e = aux3.desencolar();
            System.out.print(e.getId() + "\t");
        }
        System.out.println("\n");
    }
    
    
    public Expediente sacarUltimo(){
        int prioridad = this.ultimoExp.getPrioridad();
        if(prioridad == 1){
            this.setP1(sacarU(p1, this.ultimoExp));
            return ultimoExp;
        }else if(prioridad == 2){
            this.setP2(sacarU(p2, this.ultimoExp));
            return ultimoExp;
        }else if(prioridad == 3){
            this.setP3(sacarU(p3, this.ultimoExp));
            return ultimoExp;
        }else{
            return null;
        }
    }
    private Cola sacarU(Cola<Expediente> cola, Expediente exp){
        Cola<Expediente> colaAux = new Cola();
        while(!cola.esVacia()){
            Expediente expAux = cola.desencolar();
            if(!expAux.getId().equalsIgnoreCase(exp.getId())){
                colaAux.encolar(expAux);
            }
        }
        return colaAux;
    }
    
    public void colocarPrincipio(Expediente exp){
        int prioridad = this.ultimoExp.getPrioridad();
        if(prioridad == 1){
            this.setP1(colocarP(p1, this.ultimoExp));
        }else if(prioridad == 2){
            this.setP2(colocarP(p2, this.ultimoExp));
        }else if(prioridad == 3){
            this.setP3(colocarP(p3, this.ultimoExp));
        }else{
            
        }
    }
    
    private Cola colocarP(Cola<Expediente> cola, Expediente exp){
        Cola<Expediente> colaAux = new Cola();
        colaAux.encolar(exp);
        while(!cola.esVacia()){
            Expediente expAux = cola.desencolar();
            colaAux.encolar(expAux);
        }
        return colaAux;
    }
    
    public boolean buscarExpediente(String id){
        Cola aux = new Cola<Expediente>();
        boolean b = false;
        while(!p1.esVacia()){
            Expediente exp =(Expediente) p1.desencolar();
            aux.encolar(exp);
            if(exp.getId().equalsIgnoreCase(id)){
                b = true;
            }
        }
        p1 = aux;
        aux = new Cola<Expediente>();
        while(!p2.esVacia()){
            Expediente exp =(Expediente) p2.desencolar();
            aux.encolar(exp);
            if(exp.getId().equalsIgnoreCase(id)){
                b = true;
            }
        }
        p2 = aux;
        aux = new Cola<Expediente>();
        while(!p3.esVacia()){
            Expediente exp =(Expediente) p3.desencolar();
            aux.encolar(exp);
            if(exp.getId().equalsIgnoreCase(id)){
                b = true;
            }
        }
        p3 = aux;
        aux = new Cola<Expediente>();
        return b;
    }
    
    public void finalizarExpediente(String id){
        Cola aux = new Cola<Expediente>();
        while(!p1.esVacia()){
            Expediente exp =(Expediente) p1.desencolar();
            if(exp.getId().equalsIgnoreCase(id)){
                exp.finExpediente();
            }
            aux.encolar(exp);
        }
        p1 = aux;
        aux = new Cola<Expediente>();
        while(!p2.esVacia()){
            Expediente exp =(Expediente) p2.desencolar();
            if(exp.getId().equalsIgnoreCase(id)){
                exp.finExpediente();
            }
            aux.encolar(exp);
        }
        p2 = aux;
        aux = new Cola<Expediente>();
        while(!p3.esVacia()){
            Expediente exp =(Expediente) p3.desencolar();
            if(exp.getId().equalsIgnoreCase(id)){
                exp.finExpediente();
            }
            aux.encolar(exp);
        }
        p3 = aux;
        aux = new Cola<Expediente>();
    }
}
