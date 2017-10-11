package ec.edu.upse.locatemeapp.modelo;

/**
 * Created by gitwyn_pc on 11/10/2017.
 */

public class TipoDiscapacidad {
    private Long idtipoDiscapacidad;
    private String usuTipoDescripcion;
    private String usuTipoEstado;
    private String usuTipoObservaciones;

    public TipoDiscapacidad() {
    }

    public Long getIdtipoDiscapacidad() {
        return idtipoDiscapacidad;
    }

    public void setIdtipoDiscapacidad(Long idtipoDiscapacidad) {
        this.idtipoDiscapacidad = idtipoDiscapacidad;
    }

    public String getUsuTipoDescripcion() {
        return usuTipoDescripcion;
    }

    public void setUsuTipoDescripcion(String usuTipoDescripcion) {
        this.usuTipoDescripcion = usuTipoDescripcion;
    }

    public String getUsuTipoEstado() {
        return usuTipoEstado;
    }

    public void setUsuTipoEstado(String usuTipoEstado) {
        this.usuTipoEstado = usuTipoEstado;
    }

    public String getUsuTipoObservaciones() {
        return usuTipoObservaciones;
    }

    public void setUsuTipoObservaciones(String usuTipoObservaciones) {
        this.usuTipoObservaciones = usuTipoObservaciones;
    }
}
