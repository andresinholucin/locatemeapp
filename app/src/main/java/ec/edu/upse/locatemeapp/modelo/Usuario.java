package ec.edu.upse.locatemeapp.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements Parcelable {
   private Integer idusuario;
    private String  usuUAnio;
    private String  usuUApellidos;
    private String  usuUCedula;
    private String usuUClave;
    private String usuUCorreo;
    private String usuUDia;
    private String usuUDireccion;
    private String usuUEstado;
    private String usuUMes;
    private String usuUNombres;
    private String usuUSms;
    private String usuUTelefono;
    private String usuUUsuario;
/*
    private List<UsuarioAsignado> usuarioAsignados1;

    private List<UsuarioAsignado> usuarioAsignados2;
*/
    private TipoDiscapacidad tipoDiscapacidad;

    public Usuario() {
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuUAnio() {
        return usuUAnio;
    }

    public void setUsuUAnio(String usuUAnio) {
        this.usuUAnio = usuUAnio;
    }

    public String getUsuUApellidos() {
        return usuUApellidos;
    }

    public void setUsuUApellidos(String usuUApellidos) {
        this.usuUApellidos = usuUApellidos;
    }

    public String getUsuUCedula() {
        return usuUCedula;
    }

    public void setUsuUCedula(String usuUCedula) {
        this.usuUCedula = usuUCedula;
    }

    public String getUsuUClave() {
        return usuUClave;
    }

    public void setUsuUClave(String usuUClave) {
        this.usuUClave = usuUClave;
    }

    public String getUsuUCorreo() {
        return usuUCorreo;
    }

    public void setUsuUCorreo(String usuUCorreo) {
        this.usuUCorreo = usuUCorreo;
    }

    public String getUsuUDia() {
        return usuUDia;
    }

    public void setUsuUDia(String usuUDia) {
        this.usuUDia = usuUDia;
    }

    public String getUsuUDireccion() {
        return usuUDireccion;
    }

    public void setUsuUDireccion(String usuUDireccion) {
        this.usuUDireccion = usuUDireccion;
    }

    public String getUsuUEstado() {
        return usuUEstado;
    }

    public void setUsuUEstado(String usuUEstado) {
        this.usuUEstado = usuUEstado;
    }

    public String getUsuUMes() {
        return usuUMes;
    }

    public void setUsuUMes(String usuUMes) {
        this.usuUMes = usuUMes;
    }

    public String getUsuUNombres() {
        return usuUNombres;
    }

    public void setUsuUNombres(String usuUNombres) {
        this.usuUNombres = usuUNombres;
    }

    public String getUsuUSms() {
        return usuUSms;
    }

    public void setUsuUSms(String usuUSms) {
        this.usuUSms = usuUSms;
    }

    public String getUsuUTelefono() {
        return usuUTelefono;
    }

    public void setUsuUTelefono(String usuUTelefono) {
        this.usuUTelefono = usuUTelefono;
    }

    public String getUsuUUsuario() {
        return usuUUsuario;
    }
/*
    public void setUsuUUsuario(String usuUUsuario) {
        this.usuUUsuario = usuUUsuario;
    }
    public List<UsuarioAsignado> getUsuarioAsignados1() {
        return usuarioAsignados1;
    }

    public void setUsuarioAsignados1(List<UsuarioAsignado> usuarioAsignados1) {
        this.usuarioAsignados1 = usuarioAsignados1;
    }

    public List<UsuarioAsignado> getUsuarioAsignados2() {
        return usuarioAsignados2;
    }

    public void setUsuarioAsignados2(List<UsuarioAsignado> usuarioAsignados2) {
        this.usuarioAsignados2 = usuarioAsignados2;
    }
*/
    public TipoDiscapacidad getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(TipoDiscapacidad tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idusuario);
        dest.writeString(this.usuUAnio);
        dest.writeString(this.usuUApellidos);
        dest.writeString(this.usuUCedula);
        dest.writeString(this.usuUClave);
        dest.writeString(this.usuUCorreo);
        dest.writeString(this.usuUDia);
        dest.writeString(this.usuUDireccion);
        dest.writeString(this.usuUEstado);
        dest.writeString(this.usuUMes);
        dest.writeString(this.usuUNombres);
        dest.writeString(this.usuUSms);
        dest.writeString(this.usuUTelefono);
        dest.writeString(this.usuUUsuario);
     /*   dest.writeList(this.usuarioAsignados1);
        dest.writeList(this.usuarioAsignados2);*/
    }

    protected Usuario(Parcel in) {
        this.idusuario = (Integer) in.readValue(Integer.class.getClassLoader());
        this.usuUAnio = in.readString();
        this.usuUApellidos = in.readString();
        this.usuUCedula = in.readString();
        this.usuUClave = in.readString();
        this.usuUCorreo = in.readString();
        this.usuUDia = in.readString();
        this.usuUDireccion = in.readString();
        this.usuUEstado = in.readString();
        this.usuUMes = in.readString();
        this.usuUNombres = in.readString();
        this.usuUSms = in.readString();
        this.usuUTelefono = in.readString();
        this.usuUUsuario = in.readString();
       /* this.usuarioAsignados1 = new ArrayList<UsuarioAsignado>();
        in.readList(this.usuarioAsignados1, UsuarioAsignado.class.getClassLoader());
        this.usuarioAsignados2 = new ArrayList<UsuarioAsignado>();
        in.readList(this.usuarioAsignados2, UsuarioAsignado.class.getClassLoader());*/
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
