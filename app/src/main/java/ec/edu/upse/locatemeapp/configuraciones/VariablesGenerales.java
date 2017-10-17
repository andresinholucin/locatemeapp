package ec.edu.upse.locatemeapp.configuraciones;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.locatemeapp.modelo.Perimetro;
import ec.edu.upse.locatemeapp.modelo.TiempoSensado;
import ec.edu.upse.locatemeapp.modelo.TipoDiscapacidad;

/**
 * Created by gitwyn_pc on 11/10/2017.
 */

public class VariablesGenerales extends Application{

    public List<TipoDiscapacidad> listaTipoDiscapacidad;
    public List<TiempoSensado> listaTiempoSensado;
    public List<Perimetro> listaPerimetro;

    public List<TipoDiscapacidad> getListaTipoDiscapacidad() {
        return listaTipoDiscapacidad;
    }

    public void setListaTipoDiscapacidad(List<TipoDiscapacidad> listaTipoDiscapacidad) {
        this.listaTipoDiscapacidad = listaTipoDiscapacidad;
    }

    public List<TiempoSensado> getListaTiempoSensado() {
        return listaTiempoSensado;
    }

    public void setListaTiempoSensado(List<TiempoSensado> listaTiempoSensado) {
        this.listaTiempoSensado = listaTiempoSensado;
    }

    public List<Perimetro> getListaPerimetro() {
        return listaPerimetro;
    }

    public void setListaPerimetro(List<Perimetro> listaPerimetro) {
        this.listaPerimetro = listaPerimetro;
    }
}
