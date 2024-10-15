package com.example.judith_fernandez_suarez_pmdm_tarea_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginCorrecto extends AppCompatActivity {

    private TextView textViewBienvenido;
    private Button buttonCrearAlarma;
    private ImageButton imageButtonLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_correcto);

        textViewBienvenido = findViewById(R.id.textViewBienvenido);
        buttonCrearAlarma = findViewById(R.id.buttonCrearAlarma);
        imageButtonLink = findViewById(R.id.imageButtonLink);

        // Obtenemos el nombre del usuario
        String nombreUsuario = getIntent().getStringExtra("NOMBRE");
        textViewBienvenido.setText("¡Bienvenido, " + nombreUsuario + "!");

        // Pasar del boton crear alarma a la clase de CrearAlarma
        buttonCrearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginCorrecto.this, CrearAlarma.class);
                startActivity(intent);
            }
        });

        // Abrir la web
        imageButtonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre un enlace a una URL
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/android/index.htm"));
                startActivity(browserIntent);
            }
        });
    }
}
