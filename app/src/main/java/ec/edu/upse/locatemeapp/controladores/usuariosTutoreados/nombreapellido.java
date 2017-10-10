package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class nombreapellido extends AppCompatActivity  implements View.OnClickListener{
    Button btnsiguiente;
    Spinner listadiscapacidad;
    EditText txt_nombre;
    EditText txt_apellido;

    Integer discapacidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombreapellido);

        btnsiguiente =(Button)findViewById(R.id.buttonsiguiente);
        btnsiguiente.setOnClickListener(this);

        listadiscapacidad=(Spinner)findViewById(R.id.discapacidades);

        txt_nombre=(EditText)findViewById(R.id.editTextnombre);
        txt_apellido=(EditText)findViewById(R.id.editTextapellido);



    }

    //pasar de una pantalla a otra
    @Override
    public void onClick(View v) {
        if(v==btnsiguiente){

            if (listadiscapacidad.toString()=="Adulto Mayor") {
                discapacidad=1; }
            if(listadiscapacidad.toString() =="Discapacidad Fisica") {
                discapacidad=2;}
            if (listadiscapacidad.toString() =="Discapacidad de Lenguaje") {
                discapacidad=3;}
            else{discapacidad=4;}

            Usuario usuario= new Usuario();
            usuario.setUsuUNombres(txt_nombre.getText().toString());
            usuario.setUsuUApellidos(txt_apellido.getText().toString());


            Intent intent=new Intent(nombreapellido.this, usuariocontrasenia.class);
            //pasar objeto Usuario a otro activity
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }



    }
}
