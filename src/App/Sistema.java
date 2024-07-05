/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import TDA.*;
import java.util.Arrays;

/**
 *
 * @author esteb
 */
public class Sistema {
    public static Lista movimientos;
    public static GestionExpediente GestionExp;
    public static GestionDependencia GestionDep;
    public static GestionInteresado GestionInt;
    
    public Sistema(){
        movimientos = new Lista<Movimiento>();
        GestionExp = new GestionExpediente();
        GestionDep = new GestionDependencia();
        GestionInt = new GestionInteresado();
        Dependencia aux = new Dependencia("Administracion", "");
        GestionDep.agregarDependencia(aux);
    }

    public static Lista getMovimientos() {
        return movimientos;
    }

    public static void setMovimientos(Lista movimientos) {
        Sistema.movimientos = movimientos;
    }

    public static GestionInteresado getGestionInt() {
        return GestionInt;
    }

    public static void setGestionInt(GestionInteresado GestionInt) {
        Sistema.GestionInt = GestionInt;
    }
    
    public static GestionExpediente getGestionExp() {
        return GestionExp;
    }

    public static void setGestionExp(GestionExpediente GestionExp) {
        Sistema.GestionExp = GestionExp;
    }

    public static GestionDependencia getGestionDep() {
        return GestionDep;
    }

    public static void setGestionDep(GestionDependencia GestionDep) {
        Sistema.GestionDep = GestionDep;
    }
    
    public static void actualizarDatos(GestionExpediente GE, GestionDependencia GD, GestionInteresado GI){
        GestionExp = GE;
        GestionDep = GD;
        GestionInt = GI;
    }
    
    public static Movimiento extraerMovimiento(String id){
        for(int i = 1; i <= movimientos.longitud(); i++){
            Movimiento aux = (Movimiento) movimientos.iesimo(i);
            if(aux.getIdExp().equalsIgnoreCase(id)){
                return aux;
            }
        }
        return null;
    }
    
    public static void actualizarMovimiento(Movimiento newMov){
        for(int i = 1; i <= movimientos.longitud(); i++){
            Movimiento aux = (Movimiento) movimientos.iesimo(i);
            if(aux.getIdExp().equalsIgnoreCase(newMov.getIdExp())){
                movimientos.eliminar(i);
                movimientos.insertar(newMov, i);
            }
        }
    }
    
    public static void eliminarSeguimiento(String id){
        for(int i = 1; i <= movimientos.longitud(); i++){
            Movimiento aux = (Movimiento) movimientos.iesimo(i);
            if(aux.getIdExp().equalsIgnoreCase(id)){
                movimientos.eliminar(i);
                break;
            }
        }
    }
    
    public static void deshacerAccion(String id){
        Movimiento aux = extraerMovimiento(id);
        if(!aux.getNombreDeps().isEmpty()){
            String nombreDepFin = (String) aux.getNombreDeps().pop();
            String nombreDepInicio = "";
            if(aux.getNombreDeps().isEmpty()){
                nombreDepInicio = "Administracion";
            }else{
                nombreDepInicio = (String) aux.getNombreDeps().top();
            }
            Lista<Dependencia> dependencias = GestionDep.getDependencias();

            Expediente exp = null;
            for(int i = 1; i <= dependencias.longitud(); i++){
                if(dependencias.iesimo(i).getNombre().equalsIgnoreCase(nombreDepFin)){
                    exp = dependencias.iesimo(i).sacarUltimo();
                    break;
                }
            }

            for(int i = 1; i <= dependencias.longitud(); i++){
                if(dependencias.iesimo(i).getNombre().equalsIgnoreCase(nombreDepInicio)){
                    dependencias.iesimo(i).colocarPrincipio(exp);
                    break;
                }
            }

            GestionDep.setDependencias(dependencias);

            Lista<Expediente> expedientes = GestionExp.getExpedientes();
            for(int i = 1; i <= expedientes.longitud(); i++){
                if(expedientes.iesimo(i).getId().equalsIgnoreCase(id)){
                    expedientes.iesimo(i).setNombreDep(nombreDepInicio);
                }
            }

            GestionExp.setExpedientes(expedientes);
            
        }else{
            
        }
    }
        
}
