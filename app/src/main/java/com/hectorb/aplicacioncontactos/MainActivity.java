package com.hectorb.aplicacioncontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;
    Contacto contacto,contactoAnterior;
    Bundle parametros;
    TextInputEditText textFieldNombre;
    TextInputEditText textFieldFecha;
    TextInputEditText textFieldTelefono;
    TextInputEditText textFieldEmail;
    TextInputEditText textFieldDescripcion;
    DatePicker selectorFecha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFieldNombre         = findViewById(R.id.textFieldNombre);
        textFieldTelefono       = findViewById(R.id.textFieldTelefono);
        textFieldEmail          = findViewById(R.id.textFieldEmail);
        textFieldDescripcion    = findViewById(R.id.textFieldDescripcion);
        selectorFecha           = findViewById(R.id.selectorFecha);


        //aqui se revisan los parametros si viene de un botón back de la
        //actividad siguiente
        parametros = getIntent().getExtras();
        if(parametros!=null){
            setParametros(parametros);
        }

        //aqui se manda a la siguiente actividad
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatos();

                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(Contacto.TAG_NOMBRE,contacto.getNombre());
                intent.putExtra(Contacto.TAG_FECHA,contacto.getFechaNac());
                intent.putExtra(Contacto.TAG_TELEFONO,contacto.getTelefono());
                intent.putExtra(Contacto.TAG_EMAIL,contacto.getEmail());
                intent.putExtra(Contacto.TAG_DESCRIPCION,contacto.getDescripcion());
                startActivity(intent);

                finish();
            }
        });

    }

    //Obtiene los datos de todos los campos
    public void getDatos(){

        String fechaNac             = selectorFecha.getDayOfMonth() + "/" + selectorFecha.getMonth()
                                        + "/" + selectorFecha.getYear();


        contacto = new Contacto(
                textFieldNombre.getText().toString(),
                fechaNac,
                textFieldTelefono.getText().toString(),
                textFieldEmail.getText().toString(),
                textFieldDescripcion.getText().toString()
        );
    }

    //Obtiene los parametros de la actividad DetalleContacto en caso de haberlos
    public void setParametros(Bundle datosContacto){
        contactoAnterior = new Contacto(
                datosContacto.getString(Contacto.TAG_NOMBRE),
                datosContacto.getString(Contacto.TAG_FECHA),
                datosContacto.getString(Contacto.TAG_TELEFONO),
                datosContacto.getString(Contacto.TAG_EMAIL),
                datosContacto.getString(Contacto.TAG_DESCRIPCION)
        );

        textFieldNombre.setText(contactoAnterior.getNombre());
        textFieldTelefono.setText(contactoAnterior.getTelefono());
        textFieldEmail.setText(contactoAnterior.getEmail());
        textFieldDescripcion.setText(contactoAnterior.getDescripcion());

        String[] fecha = contactoAnterior.getFechaNac().split("/");
        int dia = Integer.parseInt(fecha[0]);
        int mes = Integer.parseInt(fecha[1]);
        int ano = Integer.parseInt(fecha[2]);

        selectorFecha.updateDate(ano,mes,dia);


    }
}
