package com.login.chayo;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_outgoin_products extends AppCompatActivity {

    private EditText etOutgoingProductName, etOutgoingQuantity;
    private Button btnSubmitOutgoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outgoing_products);

        // Enlazar vistas
        etOutgoingProductName = findViewById(R.id.etOutgoingProductName);
        etOutgoingQuantity = findViewById(R.id.etOutgoingQuantity);
        btnSubmitOutgoing = findViewById(R.id.btnSubmitOutgoing);

        btnSubmitOutgoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = etOutgoingProductName.getText().toString();
                String outgoingQuantity = etOutgoingQuantity.getText().toString();

                if (productName.isEmpty() || outgoingQuantity.isEmpty()) {
                    Toast.makeText(activity_outgoin_products.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lógica para manejar la salida de productos
                Toast.makeText(activity_outgoin_products.this, "Producto saliente registrado:\nNombre: "
                        + productName + "\nCantidad: " + outgoingQuantity, Toast.LENGTH_SHORT).show();

                // Limpiar campos
                etOutgoingProductName.setText("");
                etOutgoingQuantity.setText("");
            }
        });
    }
}
