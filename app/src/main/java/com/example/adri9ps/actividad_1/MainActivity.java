package com.example.adri9ps.actividad_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button btnEnviar;
    private final String TAG = "Prueba";
    final int SUBACT_1=345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button) findViewById(R.id.id_btnEnviar);
        nombre = (EditText) findViewById(R.id.id_nombre);


        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "Nombre: " + nombre.getText());

                //Objeto intent
                Intent i = new Intent(getApplicationContext(), Activity2.class);

                //Objeto bundle para poder pasar los datos
                Bundle parametros = new Bundle();
                //String=CharSequence y el "nombreusuario" es la clave
                parametros.putString("nombreUsuario",nombre.getText().toString());
                //Para pasarle al intent el objeto bundle
                i.putExtras(parametros);
                startActivityForResult(i,SUBACT_1);
                //startActivity(i);
            }


            });
       // }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SUBACT_1){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,"El subactivity se ha realizado correctamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El subactivity se ha cancelado",Toast.LENGTH_LONG).show();
            }
        }
    }

}
