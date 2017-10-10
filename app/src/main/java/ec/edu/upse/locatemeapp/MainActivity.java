package ec.edu.upse.locatemeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ec.edu.upse.locatemeapp.controladores.usuariosTutoreados.UsuarioControlador;

public class MainActivity extends AppCompatActivity {

    Button btn_usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_usuario=(Button)findViewById(R.id.button);

    }

    public  void btn_usuario(View view){
        Intent intent = new Intent(this, UsuarioControlador.class);
        startActivity(intent);
    }


}
