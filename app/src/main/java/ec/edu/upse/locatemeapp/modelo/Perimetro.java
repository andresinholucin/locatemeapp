package ec.edu.upse.locatemeapp.modelo;

/**
 * Created by gitwyn_pc on 05/10/2017.
 */

public class Perimetro {
    private int idperimetroSensado;
    private String usuPerimetroDescripcion;
    private String usuPerimetroEstado;

    public int getIdperimetroSensado() {
        return idperimetroSensado;
    }

    public void setIdperimetroSensado(int idperimetroSensado) {
        this.idperimetroSensado = idperimetroSensado;
    }

    public String getUsuPerimetroDescripcion() {
        return usuPerimetroDescripcion;
    }

    public void setUsuPerimetroDescripcion(String usuPerimetroDescripcion) {
        this.usuPerimetroDescripcion = usuPerimetroDescripcion;
    }

    public String getUsuPerimetroEstado() {
        return usuPerimetroEstado;
    }

    public void setUsuPerimetroEstado(String usuPerimetroEstado) {
        this.usuPerimetroEstado = usuPerimetroEstado;
    }

    @Override
    public String toString() {
        return "{" +
                "idperimetroSensado=" + idperimetroSensado +
                ", usuPerimetroDescripcion='" + usuPerimetroDescripcion + '\'' +
                ", usuPerimetroEstado='" + usuPerimetroEstado + '\'' +
                '}';
    }
}
