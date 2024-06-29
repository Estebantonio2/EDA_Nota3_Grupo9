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
public class GestionInteresado {
    private int cantidad;
    private Lista interesados;

    public GestionInteresado() {
        interesados = new Lista<Interesado>();
        cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Lista getInteresados() {
        return interesados;
    }

    public void setInteresados(Lista interesados) {
        this.interesados = interesados;
    }
    
    public void agregarInteresado(Interesado interesado){
        this.interesados.agregar(interesado);
    }
    
    public void eliminarInteresado(String Nombre){
        for(int i = 1; i <= this.interesados.longitud(); i++){
            Interesado inte = (Interesado) this.interesados.iesimo(i);
            if(inte.getNombre().equalsIgnoreCase(Nombre)){
                this.interesados.eliminar(inte);
                break;
            }
        }
    }
    
}
