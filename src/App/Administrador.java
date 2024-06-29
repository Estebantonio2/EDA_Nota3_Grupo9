/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

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
    
    // pense que se podria nombrar al objeto como parametro, pero no, chequear, posible solucion
    public void ingresarInteresado(Interesado interesado, String DNI, String nombre, String telefono, String email, String tipo){
        interesado.setDNI(DNI);
        interesado.setNombre(nombre);
        interesado.setTelefono(telefono);
        interesado.setEmail(email);
        interesado.setTipo(tipo);
        Sistema.GestionInt.agregarInteresado(interesado);
        Sistema.variable = 1;
    }
    
    public void ingresarExpediente(Expediente expediente, String id, String asunto, String documentoRef, 
            int prioridad, Interesado interesado, Dependencia dependencia){
        expediente.setAsunto(asunto);
        expediente.setDependencia(dependencia);
        expediente.setDocumentoRef(documentoRef);
        expediente.setId(id);
        expediente.setInteresado(interesado);
        expediente.setPrioridad(prioridad);
        Sistema.GestionExp.agregarExpediente(expediente);
        Sistema.variable = 2;
    }
    
    public void registrarMovimiento(Expediente expediente, Dependencia dependencia){
        Dependencia[] dependencias = Sistema.GestionDep.getDependencias();
        
    }
    
    public void deshacerMovimiento(){
        
    }
    
    public void registrarFinalizacion(){
        
    }
    
    public void mostrarTramite(){
        
    }
}
