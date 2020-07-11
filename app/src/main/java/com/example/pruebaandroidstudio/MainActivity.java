package com.example.pruebaandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3;
    String nombre = et1.getText().toString();
    String correo = et2.getText().toString();
    String celular = et3.getText().toString();
    ListView listv;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txt1);
        et2 = (EditText) findViewById(R.id.txt2);
        et3 = (EditText) findViewById(R.id.txt3);

        listv = findViewById(R.id.datos);

        inicializarfirebase();
    }

    private void inicializarfirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
