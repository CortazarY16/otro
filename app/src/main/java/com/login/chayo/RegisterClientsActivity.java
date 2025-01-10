package com.login.chayo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RegisterClientsActivity extends AppCompatActivity {

    private EditText etClientName, etClientPhone;
    private Button btnRegisterClient;
    private ListView lista;
    List<String>items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_clients);

        // Enlazar vistas
        etClientName = findViewById(R.id.etClientName);
        etClientPhone = findViewById(R.id.etClientPhone);
        btnRegisterClient = findViewById(R.id.btnRegisterClient);
        items =new ArrayList<>();
        lista .setOnClickListener(new View.OnClickListener() {


            {
            }

            @Override
            public void onClick(View v) {
                String clientName = etClientName.getText().toString();
                String clientPhone = etClientPhone.getText().toString();

                if (clientName.isEmpty() || clientPhone.isEmpty()) {
                    Toast.makeText(RegisterClientsActivity.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lógica para registrar el cliente
                Toast.makeText(RegisterClientsActivity.this, "Cliente registrado:\nNombre: "
                        + clientName + "\nTeléfono: " + clientPhone, Toast.LENGTH_SHORT).show();

                // Limpiar campos
                etClientName.setText("");
                etClientPhone.setText("");

            }
        });
    }
}
