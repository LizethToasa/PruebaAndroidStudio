package com.example.pruebaandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3;
    String nombre = et1.getText().toString();
    String correo = et2.getText().toString();
    String celular = et3.getText().toString();
    Button btn1, btn2, btn3, btn4;
    ListView listv;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_add:
                if (nombre.equals("") || correo.equals("") || celular.equals("")){
                    validacion();
                }else{
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }
                break;
            case R.id.icon_save:
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_delete:
                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }

        return true;
    }

    private void limpiar() {
        try{
            nombre = ("");
            correo = ("");
            celular = ("");
        }catch (Exception e){};
    }

    private void validacion() {
        if(!nombre.isEmpty() && !correo.isEmpty() && !celular.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("correo", correo);
            registro.put("celular", celular);

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "LLene todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
