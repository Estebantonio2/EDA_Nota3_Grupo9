/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import TDA.*;

/**
 *
 * @author Sistema
 */
public class Administrador {
    private String nombreUsuario, contraseña;

    public Administrador() {
    }

    public Administrador(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void actualizarEncargado(){
        Lista<Dependencia> dependencias = Sistema.GestionDep.getDependencias();
        dependencias.iesimo(1).setEncargado(this.nombreUsuario);
        Sistema.GestionDep.setDependencias(dependencias);
    }
    
    public void ingresarInteresado(Interesado interesado, String DNI, String nombre, String telefono, String email, String tipo){
        interesado.setDNI(DNI);
        interesado.setNombre(nombre);
        interesado.setTelefono(telefono);
        interesado.setEmail(email);
        interesado.setTipo(tipo);
        Sistema.GestionInt.agregarInteresado(interesado);
    }

    public void ingresarExpediente(Expediente expediente, String id, String asunto, String documentoRef, 
            Interesado interesado, int prioridad){
        expediente.setAsunto(asunto);
        expediente.setDocumentoRef(documentoRef);
        expediente.setId(id);
        expediente.setPrioridad(prioridad);
        expediente.setInteresado(interesado);
        expediente.setNombreDep("Administracion");
        
        Sistema.GestionExp.agregarExpediente(expediente);
        
        Lista<Dependencia> dependencias = Sistema.GestionDep.getDependencias();
        dependencias.iesimo(1).agregarExpediente(expediente);
        Sistema.GestionDep.setDependencias(dependencias);
        
        Movimiento m = new Movimiento(expediente.getId());
        Sistema.movimientos.agregar(m);
        
        Sistema.variable = 2;
    }
    
    public boolean registrarMovimiento(String id, String nombreDep2){
        if(Sistema.GestionDep.getDependencias().longitud() > 1){
            Lista<Dependencia> dependencias = Sistema.GestionDep.getDependencias();
            int posActual = 0;
            for(int i = 1; i <= dependencias.longitud(); i++){
                if(dependencias.iesimo(i).buscarExpediente(id)){
                    posActual = i;
                }
            }
            Expediente exp = (Expediente) dependencias.iesimo(posActual).extraerExpediente(id);
            
            for(int i = 1; i <= dependencias.longitud(); i++){
                if(dependencias.iesimo(i).getNombre().equalsIgnoreCase(nombreDep2)){
                    dependencias.iesimo(i).agregarExpediente(exp);
                }
            }
            
            Lista<Expediente> expedientes = Sistema.GestionExp.getExpedientes();
            for(int i = 1; i <= expedientes.longitud(); i++){
                if(expedientes.iesimo(i).getId().equalsIgnoreCase(id)){
                    expedientes.iesimo(i).setNombreDep(nombreDep2);
                }
            }
            
            if(posActual != 0){
                Sistema.GestionDep.setDependencias(dependencias);
                Sistema.GestionExp.setExpedientes(expedientes);
                Movimiento aux = Sistema.extraerMovimiento(exp.getId());
                aux.agregarMovimiento(nombreDep2);
                Sistema.actualizarMovimiento(aux);
                return true;
            }else{
                return false;
            }
        }

        return false;
    }
    
    public void registrarFinalizacion(String id){
        Lista<Expediente> expedientes = Sistema.GestionExp.getExpedientes();
        for(int i = 1; i <= expedientes.longitud(); i++){
            if(expedientes.iesimo(i).getId().equalsIgnoreCase(id)){
                expedientes.iesimo(i).finExpediente();
            }
        }
        Sistema.GestionExp.setExpedientes(expedientes);
        Lista<Dependencia> dependencias = Sistema.GestionDep.getDependencias();
        for(int i = 1; i <= dependencias.longitud(); i++){
            if(dependencias.iesimo(i).buscarExpediente(id)){
                dependencias.iesimo(i).finalizarExpediente(id);
            }
        }
        Sistema.GestionDep.setDependencias(dependencias);
    }
    
    public void eliminarExpediente(String id){
        Sistema.GestionExp.eliminarExpediente(id);
        Lista<Dependencia> dependencias = Sistema.GestionDep.getDependencias();
        for(int i = 1; i <= dependencias.longitud(); i++){
            if(dependencias.iesimo(i).buscarExpediente(id)){
                dependencias.iesimo(i).extraerExpediente(id);
            }
        }
        Sistema.GestionDep.setDependencias(dependencias);
        Lista<Movimiento> movimientos = Sistema.getMovimientos();
        for(int i = 1; i <= movimientos.longitud(); i++){
            if(movimientos.iesimo(i).getIdExp().equalsIgnoreCase(id)){
                movimientos.eliminar(i);
                break;
            }
        }
        Sistema.setMovimientos(movimientos);
    }
}
