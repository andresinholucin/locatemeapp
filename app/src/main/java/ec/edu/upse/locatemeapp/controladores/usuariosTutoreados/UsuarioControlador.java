package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.configuraciones.ParametrosConexion;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class UsuarioControlador extends AppCompatActivity {

    Button btn_rest;
    public ListView lista;
    List<Usuario> listaUsuarios= new ArrayList<Usuario>();
    Usuario usuarioSeleccionado = new Usuario();
    ParametrosConexion con =new ParametrosConexion();
    FloatingActionButton floatingActionButton;
    ProgressBar progrescircular;
    List<String> str_Lista=new ArrayList<String>();
    ArrayAdapter<String> adaptador;
    String var;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        addObjetos();

        //boton flotante para añadir agregar nuevos usuarios
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),nombreapellido.class);
                startActivity(i);
            }
        });

        new HttpListaTutoreado().execute();

        //seleccionar un usuario y llamar a menu emergente
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /// Obtiene el valor de la casilla elegida
                String itemSeleccionado = parent.getItemAtPosition(position).toString();
                usuarioSeleccionado=(Usuario)parent.getItemAtPosition(position);
                // muestra un mensaje
                Toast.makeText(getApplicationContext(), "La persona Seleccionada es: " +
                        usuarioSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lista);

    }

    private void addObjetos(){
        //btn_rest=(Button)findViewById(R.id.btn_rest);
        lista = (ListView)findViewById(R.id.listView);
        //boton flotante
        floatingActionButton=(FloatingActionButton)findViewById(R.id.flotingaction);
        //progres bar circular
        progrescircular= (ProgressBar)findViewById(R.id.progressBarcircular);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id=v.getId();
        MenuInflater inflater=getMenuInflater();
        switch (id){
            case R.id.listView:
                inflater.inflate(R.menu.menu_contextual_listview,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }


    public void llamarestpost(View view){
        new HttpEnviaPost().execute();
        //new HttpEnviaPostUsuario().execute();
    }

    //metodo para hacer la peticion al web service.- metodo usuaruiotutoreadio y trae la lista de los usuarios que son tutoreados
    private class HttpListaTutoreado extends AsyncTask<Void, Void, Void > {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progreso=0;
            //progrescircular.setMax(100);
            //progrescircular.setProgress(0);
            //progrescircular.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                //final String url = "http://172.19.11.195:8084/WebServiceAlertasSpring/api/usuariotutoreado/udt/2";
                final String url=con.urlcompeta("usuariotutoreado","udt/2");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Usuario[]> response= restTemplate.getForEntity(url, Usuario[].class);
                listaUsuarios = Arrays.asList(response.getBody());

                for(Usuario usuario: listaUsuarios){
                    var=usuario.getUsuUNombres()+" "+usuario.getUsuUApellidos();
                    str_Lista.add(var);
                }

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adaptador = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,str_Lista);
            lista.setAdapter(adaptador);
            adaptador.notifyDataSetChanged();
        }
    }

//prueba del metodo post
    private class HttpEnviaPost extends AsyncTask<Void, Void, Void > {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                //final String url = "http://172.19.11.195:8084/WebServiceAlertasSpring/api/usuariotutoreado/pruebapost/";
                final String url=con.urlcompeta("usuariotutoreado","pruebapost/");
                String cadena1="probando metodo post";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                String cadena= restTemplate.postForObject(url,cadena1,String.class);
                System.out.println(cadena);
                //return listaUsuarios;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }
    }

}



/*
    private class HttpEnviaPostUsuario extends AsyncTask<Void, Void, Void > {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                final String url = "http://172.19.11.195:8084/WebServiceAlertasSpring/api/usuariotutoreado/pruebapost/";
                String cadena1="probando metodo post";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Usuario cadena= restTemplate.postForObject(url,usuarioSeleccionado,Usuario.class);
                System.out.println(cadena.toString());
                //return listaUsuarios;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }
    }
*/

/*
    private class HttpRequestTask extends AsyncTask<Void, Void, List<Usuario> > {
        @Override
        protected List<Usuario> doInBackground(Void... params) {
            try {
                final String url = "http://172.19.11.195:8084/WebServiceAlertasSpring/api/usuariotutoreado/";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Usuario[]> response=
                        restTemplate.getForEntity(url, Usuario[].class);
                List<Usuario> listaUsuarios = Arrays.asList(response.getBody());

                for(Usuario usuario: listaUsuarios){
                    System.out.println(String.valueOf(usuario.getIdusuario()));
                    System.out.println(String.valueOf(usuario.getUsuUApellidos()));

                    for (UsuarioAsignado usuarioAsignado: usuario.getUsuarioAsignados1()) {
                        System.out.println(usuarioAsignado.getIdusuarioAsignado());
                    }
                }

                /*
                //codigo para solicitar un solo objeto
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Usuario users=restTemplate.getForObject(url,Usuario.class);
                */

                //System.out.println(response);
           /*     return listaUsuarios;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }
        */

        /*@Override
        protected void onPostExecute(List<Usuario> usuarios) {
            //System.out.println(usuarios.toString());
            for(Usuario usuario: usuarios){
                System.out.println(Log.i("id",String.valueOf(usuario.getIdusuario())));
                System.out.println(Log.i("apellido", usuario.getUsuUApellidos()));
            }
        }

    }*/



//progress bar circular metodos
    /*
    private class  AsyncTask_load extends AsyncTask<Void,Integer,Void>{
        int progreso=0;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progreso=0;
            progrescircular.setMax(100);
            progrescircular.setProgress(0);
            progrescircular.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            while(progreso<100){
                progreso++;
                publishProgress(progreso);
                SystemClock.sleep(20);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progrescircular.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progrescircular.setVisibility(View.INVISIBLE);
        }
    }
*/