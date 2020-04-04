    package com.example.seccion_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.txtMensaje);

        Bundle bundle=getIntent().getExtras();//declaro las variables enviada de otro activiti

        if(bundle!=null){//verifica si bundle no es null
            String mensaje=bundle.getString("mensaje");//extrae el mensaje desde el activity main
            Toast.makeText(SecondActivity.this,mensaje,Toast.LENGTH_LONG);
            textView.setText(mensaje);
        }else{
            textView.setText("");
        }



    }
}
