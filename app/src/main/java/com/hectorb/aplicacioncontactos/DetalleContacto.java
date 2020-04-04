package com.hectorb.aplicacioncontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    Contacto contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle datosContacto = getIntent().getExtras();
        contacto = new Contacto(
                datosContacto.getString(Contacto.TAG_NOMBRE),
                datosContacto.getString(Contacto.TAG_FECHA),
                datosContacto.getString(Contacto.TAG_TELEFONO),
                datosContacto.getString(Contacto.TAG_EMAIL),
                datosContacto.getString(Contacto.TAG_DESCRIPCION)
        );

        TextView tvNombre       = findViewById(R.id.tvNombre);
        TextView tvFecha        = findViewById(R.id.tvFecha);
        TextView tvTelefono     = findViewById(R.id.tvTel);
        TextView tvEmail        = findViewById(R.id.tvEmail);
        TextView tvDescripcion  = findViewById(R.id.tvDescription);

        tvNombre.setText(contacto.getNombre());
        tvFecha.setText(contacto.getFechaNac());
        tvTelefono.setText(contacto.getTelefono());
        tvEmail.setText(contacto.getEmail());
        tvDescripcion.setText(contacto.getDescripcion());


        Button btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
        intent.putExtra(Contacto.TAG_NOMBRE,contacto.getNombre());
        intent.putExtra(Contacto.TAG_FECHA,contacto.getFechaNac());
        intent.putExtra(Contacto.TAG_TELEFONO,contacto.getTelefono());
        intent.putExtra(Contacto.TAG_EMAIL,contacto.getEmail());
        intent.putExtra(Contacto.TAG_DESCRIPCION,contacto.getDescripcion());
        startActivity(intent);
        finish();

        return super.onKeyDown(keyCode, event);
    }
}
