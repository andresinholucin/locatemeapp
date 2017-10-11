package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class usuariocontrasenia extends AppCompatActivity implements View.OnClickListener{
    Button btnsiguiente;
    EditText txt_usuario;
    EditText txt_contraseña;
    EditText txt_repitecontraseña;
    Usuario usuario;

    String nombre;
    String apellido;
    Integer discapacidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuariocontrasenia);

        btnsiguiente=(Button)findViewById(R.id.buttonsiguiente);
        btnsiguiente.setOnClickListener(this);

        txt_usuario=(EditText)findViewById(R.id.editTextusuario);
        txt_contraseña=(EditText)findViewById(R.id.editTextcontrasenia);
        txt_repitecontraseña=(EditText)findViewById(R.id.editTextrepitecontrasenia);

        usuario=getIntent().getParcelableExtra("usuario");
    }
    //pasar de una pantalla a otra
    @Override
    public void onClick(View v) {
        if(v==btnsiguiente){

            if(!txt_contraseña.getText().toString().equals(txt_repitecontraseña.getText().toString())){
                Toast.makeText(getApplicationContext(), "Contraseña Incorrecta!", Toast.LENGTH_LONG).show();
                return;
            }
/*
            usuario.setUsuUUsuario(txt_usuario.getText().toString());
            usuario.setUsuUClave(txt_contraseña.getText().toString());
            //validar contraseña*/

            Intent intent=new Intent(usuariocontrasenia.this, datospersonales1.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);

        }
    }
}
