package ec.edu.upse.locatemeapp.modelo;

/**
 * Created by gitwyn_pc on 22/09/2017.
 */

public class UsuarioAsignado {
    private Integer idusuarioAsignado;
    private String estado;
    private Usuario usuario1;
    private Usuario usuario2;

    public Integer getIdusuarioAsignado() {
        return idusuarioAsignado;
    }

    public void setIdusuarioAsignado(Integer idusuarioAsignado) {
        this.idusuarioAsignado = idusuarioAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
}
