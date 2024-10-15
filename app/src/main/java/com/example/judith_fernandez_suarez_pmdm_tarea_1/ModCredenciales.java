package com.example.judith_fernandez_suarez_pmdm_tarea_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ModCredenciales extends AppCompatActivity {

    private EditText editTextNuevoUsuario, editTextNuevaContraseña;
    private Button buttonGuardarCambios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_credenciales);

        editTextNuevoUsuario = findViewById(R.id.editTextNuevoUsuario);
        editTextNuevaContraseña = findViewById(R.id.editTextTextPassword2);
        buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios);

        // Confirmacion de modificar credenciales
        buttonGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarCredenciales();
            }
        });
    }

    private void modificarCredenciales() {
        // Obtenemos el usuario y nueva contraseña
        String nuevoUsuario = editTextNuevoUsuario.getText().toString().trim();
        String nuevaContraseña = editTextNuevaContraseña.getText().toString().trim();

        // Miramos si los campos no están vacios
        if (!nuevoUsuario.isEmpty() && !nuevaContraseña.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("NUEVO_USUARIO", nuevoUsuario);
            resultIntent.putExtra("NUEVA_CONTRASEÑA", nuevaContraseña);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
