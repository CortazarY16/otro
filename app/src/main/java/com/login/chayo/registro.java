package com.login.chayo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class registro extends AppCompatActivity {
    private EditText etProductName, etProductQuantity;
    private Button btnSaveProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r);

        // Enlazamos los componentes de la vista con el código Java
        etProductName = findViewById(R.id.etProductName);
        etProductQuantity = findViewById(R.id.etProductQuantity);
        btnSaveProduct = findViewById(R.id.btnSaveProduct);

        // Configuramos el listener para el botón Guardar
        btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = etProductName.getText().toString();
                String productQuantity = etProductQuantity.getText().toString();

                // Validamos que los campos no estén vacíos
                if (productName.isEmpty() || productQuantity.isEmpty()) {
                    Toast.makeText(registro.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lógica para guardar el producto
                // Por ejemplo, aquí podrías guardar el producto en una base de datos
                Toast.makeText(registro.this, "Producto registrado:\nNombre: "
                        + productName + "\nCantidad: " + productQuantity, Toast.LENGTH_SHORT).show();

                // Opcional: Limpiar los campos después de guardar
                etProductName.setText("");
                etProductQuantity.setText("");
            }
        });

    }
}