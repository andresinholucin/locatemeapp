package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class datospersonales2 extends AppCompatActivity implements View.OnClickListener{
    EditText txt_correo;
    EditText txt_direccion;
    Button btnaceptar;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datospersonales2);
        txt_correo=(EditText)findViewById(R.id.editTextcorreo);
        txt_direccion=(EditText)findViewById(R.id.editTextdireccion);

        btnaceptar=(Button)findViewById(R.id.buttonaceptar);
        btnaceptar.setOnClickListener(this);

        usuario=getIntent().getParcelableExtra("usuario");


    }

    @Override
    public void onClick(View v) {
        if(v==btnaceptar) {

            usuario.setUsuUCorreo(txt_correo.getText().toString());
            usuario.setUsuUDireccion(txt_direccion.getText().toString());

            Intent intent=new Intent(datospersonales2.this, configuracionUsuario.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }


        }
    }

