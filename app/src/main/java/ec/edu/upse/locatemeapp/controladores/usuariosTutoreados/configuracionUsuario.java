package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class configuracionUsuario extends AppCompatActivity {
    CheckBox chk_sms;
    EditText txt_perimetro;
    EditText txt_tiemposensado;
    Button btn_cancelar;
    Button btn_aceptar;
    Usuario usuario;
    String chk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_usuario);


    }

}
