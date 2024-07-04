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
public class GestionDependencia {
    private int cantidad;
    private Lista dependencias;
    
    public GestionDependencia(){
        dependencias = new Lista<Dependencia>();
        cantidad = 0;
    }

    public GestionDependencia(int cantidad, Lista dependencias) {
        this.cantidad = cantidad;
        this.dependencias = dependencias;
    }

    public Lista getDependencias() {
        return dependencias;
    }

    public void setDependencias(Lista dependencias) {
        this.dependencias = dependencias;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void agregarDependencia(Dependencia dependencia){
        dependencias.agregar(dependencia);
        cantidad++;
    }
    
    public void eliminarDependencia(String nombre){
        for(int i = 1; i <= this.dependencias.longitud(); i++){
            Dependencia dep = (Dependencia) this.dependencias.iesimo(i);
            if(dep.getNombre().equalsIgnoreCase(nombre)){
                this.dependencias.eliminar(dep);
                cantidad--;
                break;
            }
        }
    }
    
}
