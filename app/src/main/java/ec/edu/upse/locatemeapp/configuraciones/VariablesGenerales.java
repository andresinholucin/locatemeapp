package ec.edu.upse.locatemeapp.configuraciones;

import java.util.ArrayList;
import java.util.List;

import ec.edu.upse.locatemeapp.modelo.TipoDiscapacidad;

/**
 * Created by gitwyn_pc on 11/10/2017.
 */

public class VariablesGenerales {

    public VariablesGenerales() {
    }

    private List<TipoDiscapacidad> listaTipoDiscapacidad;

    public List<TipoDiscapacidad> getListaTipoDiscapacidad() {
        return listaTipoDiscapacidad;
    }

    public void setListaTipoDiscapacidad(List<TipoDiscapacidad> listaTipoDiscapacidad) {
        this.listaTipoDiscapacidad = listaTipoDiscapacidad;
    }
}
