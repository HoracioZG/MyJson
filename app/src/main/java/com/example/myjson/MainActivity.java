package com.example.myjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myjson.json.MyInfo;
import com.example.myjson.json.MyInfo;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyInfo myInfo = null;
        MyInfo myInfo2 = null;
        Gson gson = null;
        String json = null;
        String mensaje = null;
        String json2 = null;

        myInfo = new MyInfo();
        myInfo.setCalificacion(4.5f);
        myInfo.setEdad(17);
        myInfo.setNombre("Gerdoc");
        myInfo.setSexo( Boolean.FALSE);
        Log.d(TAG, "TEST");
        gson = new Gson();
        json = gson.toJson(myInfo);
        if ( json != null)
        {
            Log.d(TAG, json);
            mensaje = "OK";
        }
        else
        {
            mensaje = "ERROR";
        }
        Toast.makeText(getApplicationContext(), mensaje , Toast.LENGTH_SHORT).show();
        json2 = "{\"calificacion\":4.5,\"edad\":17,\"nombre\":\"Gerdoc\",\"sexo\":false}";
        myInfo2 = gson.fromJson( json2 , MyInfo.class);
        if( myInfo2 != null)
        {
            mensaje = String.format( "(%s)(%d)(%f)(%b)", myInfo2.getNombre() , myInfo2.getEdad() , myInfo2.getCalificacion() , myInfo2.getSexo() ? "F" : "M");
        }
        else
        {
            mensaje = "ERROR";
        }
        Log.d(TAG, mensaje);

    }
}