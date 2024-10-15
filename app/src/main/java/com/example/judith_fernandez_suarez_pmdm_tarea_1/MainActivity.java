package com.example.judith_fernandez_suarez_pmdm_tarea_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextContraseña;
    private Button buttonIniciarSesion, buttonModificarCredenciales;
    private static String usuarioCorrecto = "admin"; // Usuario por defecto
    private static String contraseñaCorrecta = "admin"; // Contraseña por defecto

    // ActivityResultLauncher para el ModCredenciales
    ActivityResultLauncher<Intent> launcherDatosUsuario = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // Verificamos si el resultado es correcto
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        // Obtenemos el valor de las credenciales
                        Bundle extras = result.getData().getExtras();
                        if (extras != null) {
                            usuarioCorrecto = extras.getString("NUEVO_USUARIO");
                            contraseñaCorrecta = extras.getString("NUEVA_CONTRASEÑA");

                            // Cambiamos al usuario que las credenciales fueron actualizadas
                            Toast.makeText(MainActivity.this, "Credenciales actualizadas correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextContraseña = findViewById(R.id.editTextTextPassword);
        buttonIniciarSesion = findViewById(R.id.buttonInciarSesion);
        buttonModificarCredenciales = findViewById(R.id.buttonModificarCredenciales);

        // Usuario intenta iniciar sesión
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos textos de usuario y contraseña
                String nombreUsuario = editTextNombre.getText().toString().trim();
                String contraseña = editTextContraseña.getText().toString().trim();

                // Comprobamos si el usuario y contraseña son correctos
                if (nombreUsuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta)) {
                    Intent intent = new Intent(MainActivity.this, LoginCorrecto.class);
                    intent.putExtra("NOMBRE", nombreUsuario); // Pasamos el nombre de usuario a la siguiente actividad
                    startActivity(intent);
                } else {
                    // Mostramos un mensaje si las credenciales son incorrectas
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Acción para modificar las credenciales
        buttonModificarCredenciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos un intent para abrir la actividad ModCredenciales
                Intent intent = new Intent(MainActivity.this, ModCredenciales.class);
                launcherDatosUsuario.launch(intent);
            }
        });
    }
}
