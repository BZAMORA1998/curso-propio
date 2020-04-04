package com.example.seccion_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button aceptar;
    private final String mensaje="Hola desde el segundo activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aceptar=findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hola mundo",Toast.LENGTH_LONG).show();
                //ACCEDE AL SEGUNDO ACTIVITY

                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("mensaje",mensaje);//Envia un valor
                startActivity(intent);//empieza el activitysecond

            }
        });

    }
}
