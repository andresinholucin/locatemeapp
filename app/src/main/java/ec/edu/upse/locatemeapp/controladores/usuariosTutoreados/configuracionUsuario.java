package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.configuraciones.ParametrosConexion;
import ec.edu.upse.locatemeapp.configuraciones.VariablesGenerales;
import ec.edu.upse.locatemeapp.modelo.Perimetro;
import ec.edu.upse.locatemeapp.modelo.TiempoSensado;
import ec.edu.upse.locatemeapp.modelo.TipoDiscapacidad;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class configuracionUsuario extends AppCompatActivity {
    CheckBox chk_sms;
    Button btn_cancelar;
    Button btn_aceptar;
    Usuario usuario;
    String chk;
    Spinner sp_tiemposensado;
    Spinner sp_perimetro;

    ParametrosConexion con =new ParametrosConexion();

    List<TiempoSensado> listaTiempoSensado;
    List<Perimetro> listaPerimetro;
    VariablesGenerales variablesGenerales;
    ArrayAdapter<String> adaptador;
    List<String> str_ListaTiempoSensado=new ArrayList<String>();
    List<String> str_ListaPerimetro=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_usuario);

        anadirElementos();
        validacionesIniciales();

    }

    public void anadirElementos(){
        sp_perimetro=(Spinner)findViewById(R.id.sp_perimetro);
        sp_tiemposensado=(Spinner)findViewById(R.id.sp_tiempoSensado);
        variablesGenerales = ((VariablesGenerales)getApplicationContext());
    }

    public void validacionesIniciales(){
        listaTiempoSensado= variablesGenerales.getListaTiempoSensado();
        listaPerimetro=variablesGenerales.getListaPerimetro();

        if (listaTiempoSensado==null){
            new HttpListaTiempoSensado().execute();
        }else{
            for(TiempoSensado tiempo: listaTiempoSensado){
                str_ListaTiempoSensado.add(String.valueOf(tiempo.getUsuTiempoDescripcion()));
            }
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_ListaTiempoSensado);
            sp_tiemposensado.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
        }

        if(listaPerimetro==null){
            new HttpListaPerimetros().execute();
        }else{
            for(Perimetro perimetro:listaPerimetro){
                str_ListaPerimetro.add(String.valueOf(perimetro.getUsuPerimetroDescripcion()));
                adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_ListaPerimetro);
                sp_perimetro.setAdapter(adaptador);
                adaptador.notifyDataSetChanged();
            }
        }

    }

    private class HttpListaTiempoSensado extends AsyncTask<Void, Void, Void > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                final String url=con.urlcompeta("usuariotutoreado","tiempos/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<TiempoSensado[]> response= restTemplate.getForEntity(url, TiempoSensado[].class);
                listaTiempoSensado = Arrays.asList(response.getBody());
                for(TiempoSensado tiempo: listaTiempoSensado){
                    str_ListaTiempoSensado.add(String.valueOf(tiempo.getUsuTiempoDescripcion()));
                }
                //System.out.println("llamaste la funcioj");
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            variablesGenerales.setListaTiempoSensado(listaTiempoSensado);
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_ListaTiempoSensado);
            sp_tiemposensado.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
        }
    }

    private class HttpListaPerimetros extends AsyncTask<Void, Void, Void > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                final String url=con.urlcompeta("usuariotutoreado","perimetros/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Perimetro[]> response= restTemplate.getForEntity(url, Perimetro[].class);
                listaPerimetro = Arrays.asList(response.getBody());
                for(Perimetro perimetro: listaPerimetro){
                    str_ListaPerimetro.add(String.valueOf(perimetro.getUsuPerimetroDescripcion()));
                }
                //System.out.println("llamaste la funcioj");
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            variablesGenerales.setListaPerimetro(listaPerimetro);
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_ListaPerimetro);
            sp_perimetro.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
        }
    }
}
