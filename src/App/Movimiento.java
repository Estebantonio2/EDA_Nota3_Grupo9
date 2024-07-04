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
public class Movimiento {
    private String idExp;
    private Pila nombreDeps;

    public Movimiento() {
        nombreDeps = new Pila<String>();
    }
    
    public Movimiento(String id) {
        this.idExp = id;
        nombreDeps = new Pila<String>();
    }

    public String getIdExp() {
        return idExp;
    }

    public void setIdExp(String idExp) {
        this.idExp = idExp;
    }

    public Pila getNombreDeps() {
        return nombreDeps;
    }

    public void setNombreDeps(Pila nombreDeps) {
        this.nombreDeps = nombreDeps;
    }
    
    public void agregarMovimiento(String nombreDep){
        this.nombreDeps.push(nombreDep);
    }
    
    public String deshacerMovimiento(){
        if(!nombreDeps.isEmpty()){
            return (String) nombreDeps.pop();
        }else{
            return null;
        }
    }
    
    public void mostrar(){
        System.out.println(this.idExp);
        Pila<String> aux = nombreDeps.clonar();
        while(!aux.isEmpty()){
            System.out.print(aux.pop() + "\t");
        }
        System.out.println("");
    }
}
