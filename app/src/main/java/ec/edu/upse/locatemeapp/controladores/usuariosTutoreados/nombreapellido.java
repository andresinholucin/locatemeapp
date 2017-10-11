package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import ec.edu.upse.locatemeapp.modelo.TipoDiscapacidad;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class nombreapellido extends AppCompatActivity {
    Button btnsiguiente;
    Spinner sp_listadiscapacidad;
    EditText txt_nombre;
    EditText txt_apellido;

    Usuario usuario= new Usuario();
    //List<TipoDiscapacidad> listaTipoDiscapacidad=new ArrayList<TipoDiscapacidad>();
    VariablesGenerales variablesGenerales= new VariablesGenerales();
    List<TipoDiscapacidad> listaTipoDiscapacidad=new ArrayList<TipoDiscapacidad>();

    List<String> str_Lista=new ArrayList<String>();
    ParametrosConexion con =new ParametrosConexion();
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombreapellido);
        anadirElementos();


        listaTipoDiscapacidad=variablesGenerales.getListaTipoDiscapacidad();

        if (listaTipoDiscapacidad==null){
            new HttpListaTipoDiscapacidad().execute();
            Toast toast1 = Toast.makeText(getApplicationContext(),"llenaste lista por primera vez", Toast.LENGTH_LONG);
            toast1.show();

        }else{
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_Lista);
            sp_listadiscapacidad.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
            Toast toast1 = Toast.makeText(getApplicationContext(),"llenaste lista por defecto", Toast.LENGTH_LONG);
            toast1.show();
        }

    }

    public void anadirElementos(){
        btnsiguiente =(Button)findViewById(R.id.buttonsiguiente);
        sp_listadiscapacidad=(Spinner)findViewById(R.id.discapacidades);
        txt_nombre=(EditText)findViewById(R.id.editTextnombre);
        txt_apellido=(EditText)findViewById(R.id.editTextapellido);
    }



    public  void btn_siguiente(View view){
        Intent intent = new Intent(this, usuariocontrasenia.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    //llamada al web service para llenar el combo con los tipos de discapacidades
    private class HttpListaTipoDiscapacidad extends AsyncTask<Void, Void, Void > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                final String url=con.urlcompeta("usuariotutoreado","/tiposdiscapacidad/");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<TipoDiscapacidad[]> response= restTemplate.getForEntity(url, TipoDiscapacidad[].class);
                listaTipoDiscapacidad = Arrays.asList(response.getBody());
                for(TipoDiscapacidad tipo: listaTipoDiscapacidad){
                    str_Lista.add(tipo.getUsuTipoDescripcion());
                }

                System.out.println("llamaste la funcioj");
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            variablesGenerales.setListaTipoDiscapacidad(listaTipoDiscapacidad);
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_Lista);
            sp_listadiscapacidad.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
        }
    }

}
