package com.example.judith_fernandez_suarez_pmdm_tarea_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CrearAlarma extends AppCompatActivity {

    private EditText editTextNombreAlarma, editTextHora, editTextMinutos;
    private Button buttonAlarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearalarma);

        editTextNombreAlarma = findViewById(R.id.editTextNombreAlarma);
        editTextHora = findViewById(R.id.editTextHora);
        editTextMinutos = findViewById(R.id.editTextMinutos);
        buttonAlarma = findViewById(R.id.buttonAlarma);

        // El usuario quiere crear una alarma
        buttonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlarma();
            }
        });
    }

    private void crearAlarma() {
        String nombreAlarma = editTextNombreAlarma.getText().toString().trim();
        String hora = editTextHora.getText().toString().trim();
        String minutos = editTextMinutos.getText().toString().trim();

        // Validamos que los campos estén
        if (!nombreAlarma.isEmpty() && !hora.isEmpty() && !minutos.isEmpty()) {
            // La alarma
            Toast.makeText(this, "Alarma creada para " + hora + ":" + minutos, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
