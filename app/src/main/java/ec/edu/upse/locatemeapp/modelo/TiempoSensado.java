package ec.edu.upse.locatemeapp.modelo;

/**
 * Created by gitwyn_pc on 05/10/2017.
 */

public class TiempoSensado {
    private Long idtiempoSensado;
    private int usuTiempoDescripcion;
    private String usuTiempoEstado;

    public Long getIdtiempoSensado() {
        return idtiempoSensado;
    }

    public void setIdtiempoSensado(Long idtiempoSensado) {
        this.idtiempoSensado = idtiempoSensado;
    }

    public int getUsuTiempoDescripcion() {
        return usuTiempoDescripcion;
    }

    public void setUsuTiempoDescripcion(int usuTiempoDescripcion) {
        this.usuTiempoDescripcion = usuTiempoDescripcion;
    }

    public String getUsuTiempoEstado() {
        return usuTiempoEstado;
    }

    public void setUsuTiempoEstado(String usuTiempoEstado) {
        this.usuTiempoEstado = usuTiempoEstado;
    }
}
