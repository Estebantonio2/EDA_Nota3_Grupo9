/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Sistema
 */
public class EstadoDeTramite {
    private String fechaHoraInicio, fechaHoraFinalizacion, tipoDeDocumentoTramitado;

    public EstadoDeTramite(String fechaHoraInicio, String fechaHoraFinalizacion, String tipoDeDocumentoTramitado) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.tipoDeDocumentoTramitado = tipoDeDocumentoTramitado;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(String fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public String getTipoDeDocumentoTramitado() {
        return tipoDeDocumentoTramitado;
    }

    public void setTipoDeDocumentoTramitado(String tipoDeDocumentoTramitado) {
        this.tipoDeDocumentoTramitado = tipoDeDocumentoTramitado;
    }

    




}
