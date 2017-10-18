package ec.edu.upse.locatemeapp.controladores.usuariosTutoreados;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import ec.edu.upse.locatemeapp.R;
import ec.edu.upse.locatemeapp.modelo.TipoDiscapacidad;
import ec.edu.upse.locatemeapp.modelo.Usuario;

public class datospersonales1 extends AppCompatActivity {

    Button buttonfecha;
    EditText textfecha;
    private int dia,mes,anio;

    EditText txt_cedula;
    EditText txt_telefono;

    Button btnsiguiente;
    Usuario usuario;
    TipoDiscapacidad tipoDiscapacidadSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datospersonales1);
        anadirElementos();

    }

    public void anadirElementos(){
        buttonfecha= (Button)findViewById(R.id.btn_fecha);
        textfecha=(EditText)findViewById(R.id.editTextfechanacimiento);
        txt_cedula=(EditText)findViewById(R.id.editTextcedula);
        txt_telefono=(EditText)findViewById(R.id.editTexttelefono);
        btnsiguiente=(Button)findViewById(R.id.btn_siguiente);
        usuario=getIntent().getParcelableExtra("usuario");
        tipoDiscapacidadSeleccionada=getIntent().getParcelableExtra("tipoDiscapacidad");
    }

    public void btn_siguiente(View view){
        if (validaciones()){
            usuario.setUsuUCedula(txt_cedula.getText().toString());
            usuario.setUsuUTelefono(txt_telefono.getText().toString());
            usuario.setUsuUAnio(String.valueOf(anio));
            usuario.setUsuUMes(String.valueOf(mes));
            usuario.setUsuUDia(String.valueOf(dia));

            Intent intent=new Intent(datospersonales1.this, datospersonales2.class);
            intent.putExtra("usuario", usuario);
            intent.putExtra("tipoDiscapacidad", tipoDiscapacidadSeleccionada);
            startActivity(intent);

        }

    }

    public Boolean validaciones(){
        return true;
    }

    public void btn_fecha(View view){
        final Calendar c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        anio=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textfecha.setText(dayOfMonth + " / " + (month +1 ) + " / " + year);
                dia=dayOfMonth;
                mes=month+1;
                anio=year;
                Toast.makeText(getApplicationContext(), dia +" "+mes+" "+ anio, Toast.LENGTH_SHORT).show();
            }
        }
                ,dia,mes,anio);

        datePickerDialog.show();
        Toast.makeText(getApplicationContext(), dia +" "+mes+" "+ anio, Toast.LENGTH_SHORT).show();
    }


}
