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
public class Sistema {
    public static Pila movimientos;
    public static GestionExpediente GestionExp;
    public static GestionInteresado GestionInt;
    public static GestionDependencia GestionDep;
    public static int variable;
    
    public Sistema(){
        movimientos = new Pila<Dependencia>();
        GestionExp = new GestionExpediente();
        GestionInt = new GestionInteresado();
        GestionDep = new GestionDependencia();
    }

    public static Pila getMovimientos() {
        return movimientos;
    }

    public static void setMovimientos(Pila movimientos) {
        Sistema.movimientos = movimientos;
    }

    public static GestionExpediente getGestionExp() {
        return GestionExp;
    }

    public static void setGestionExp(GestionExpediente GestionExp) {
        Sistema.GestionExp = GestionExp;
    }

    public static GestionInteresado getGestionInt() {
        return GestionInt;
    }

    public static void setGestionInt(GestionInteresado GestionInt) {
        Sistema.GestionInt = GestionInt;
    }

    public static GestionDependencia getGestionDep() {
        return GestionDep;
    }

    public static void setGestionDep(GestionDependencia GestionDep) {
        Sistema.GestionDep = GestionDep;
    }

    public static int getVariable() {
        return variable;
    }

    public static void setVariable(int variable) {
        Sistema.variable = variable;
    }
    
    public static void actualizarDatos(GestionInteresado GI, GestionExpediente GE, GestionDependencia GD){
        GestionInt = GI;
        GestionExp = GE;
        GestionDep = GD;
    }
    
    public static void mostrarAleras(){
        if(variable == 1){ // En caso se agregue interesado, notificar
            // interfaz grafica
            variable = 0;
        }else if(variable == 2){ // En caso se agregue expediente, notificar
            // interfaz grafica
            variable = 0;
        }else if(variable == 3){ // En caso se mueva un expediente, notificar
            // interfaz grafica
            variable = 0;
        }else if(variable == 4){ // En caso se deshaga movimiento, notificar
            // interfaz grafica
            variable = 0;
        }else if(variable == 5){ // Para mostrar total de expedientes
            // interfaz grafica
            int cantidad = GestionExp.getCantidad();
            variable = 0;
        }else if(variable == 6){ // Para mostrar expedientes sin finalizar
            int cantidad = 0;
            Lista<Expediente> expedientes = GestionExp.getExpedientes();
            for(int i = 1; i <= expedientes.longitud(); i++){
                Expediente exp = expedientes.iesimo(i);
                if(exp.getTiempoFin() == null){
                    cantidad++;
                }
            }
        }
    }
    
    public static void deshacerAccion(){
        Dependencia aux = (Dependencia) movimientos.top();
        
    }
}
