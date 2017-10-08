package com.example.adri9ps.actividad_1;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textoInicio;
    Button btnCancel;

    Button btnContinuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //enlazamos elementos del XML con java
        textoInicio = (TextView) findViewById(R.id.textoInicio);
        btnCancel = (Button) findViewById(R.id.btnCancelar);
        btnContinuar = (Button) findViewById(R.id.id_btnContinuar);
        //Cogemos el intent que hemos enlazado a esta actividad

        Intent i = getIntent();

        Bundle parametrosRecibidos = i.getExtras();
        if(parametrosRecibidos!=null){
            String nombreUsuario = parametrosRecibidos.getString("nombreUsuario");
            textoInicio.setText("Hola, "+nombreUsuario+" introduce tu edad: ");
        }

      btnCancel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              setResult(RESULT_CANCELED);
              finish();
          }
      });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
