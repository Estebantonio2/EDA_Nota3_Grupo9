/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author esteb
 */
public class GestionDependencia {
    private int cantidad;
    private Dependencia[] dependencias;
    
    public GestionDependencia(){
        dependencias = new Dependencia[5];
        cantidad = 0;
    }

    public Dependencia[] getDependencias() {
        return dependencias;
    }

    public void setDependencias(Dependencia[] dependencias) {
        this.dependencias = dependencias;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void agregarDependencia(Dependencia dependencia){
        if(cantidad < dependencias.length){
            dependencias[cantidad] = dependencia;
            cantidad++;
        }else{
            // interfaz grafica
        }
    }
    
    public void eliminarDependencia(String nombre){
        for(int i = 0; i < cantidad; i++){
            Dependencia dep = this.dependencias[i];
            if(dep.getNombre().equalsIgnoreCase(nombre) && i != this.dependencias.length-1){
                this.dependencias[i] = this.dependencias[i+1];
                cantidad--;
            }else{
                this.dependencias[this.dependencias.length-1] = null;
                cantidad--;
            }
        }
    }
    
}
