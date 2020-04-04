package com.example.seccion_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.lang.reflect.Modifier;

public class TercerActivity extends AppCompatActivity {

    private EditText txtPhone;
    private EditText txtWeb;
    private ImageButton btnPhone;
    private ImageButton btnWeb;
    private ImageButton btnCamera;

    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        btnCamera = findViewById(R.id.btnCamera);
        btnPhone = findViewById(R.id.btnPhone);
        btnWeb = findViewById(R.id.btnWeb);
        txtPhone = findViewById(R.id.txtPhone);
        txtWeb = findViewById(R.id.txtWeb);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhone.getText().toString();
                if (phoneNumber != null) {
                    //comprobar version actual de android que estamos corriendo
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                    } else {
                        OlderVersion(phoneNumber);
                    }
                }
            }

            private void OlderVersion(String phoneNumber) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + phoneNumber));
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                    if (ActivityCompat.checkSelfPermission(TercerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    startActivity(intentCall);
                } else {
                    Toast.makeText(TercerActivity.this, "You decline el acceso", Toast.LENGTH_LONG).show();
                }
            }

        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //COMPROBAR SI HA SIDO ACEPTADO O DENEGADO LA PETICION DE PERMISO

                    if (result == PackageManager.PERMISSION_GRANTED) {
                        //Concedio su permiso
                        String phoneNumber = txtPhone.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("Tel: " + phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        }
                        startActivity(intentCall);
                    }else{
                        //no concedio su permiso
                        Toast.makeText(TercerActivity.this,"Se denego el acceso",Toast.LENGTH_LONG).show();
                    }
                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
                break;
        }
    }

    private boolean CheckPermission(String permission){
        int result =this.checkCallingOrSelfPermission(permission);
        return  result== PackageManager.PERMISSION_GRANTED;
    }
}
