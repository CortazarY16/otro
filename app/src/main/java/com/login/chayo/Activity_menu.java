package com.login.chayo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_menu extends AppCompatActivity {
    private Button btnRegisterProduct, btnViewProducts, btnOutgoingProducts, btnRegisterClients, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnRegisterProduct = findViewById(R.id.btnRegisterProduct);
        btnViewProducts = findViewById(R.id.btnViewProducts);
        btnOutgoingProducts = findViewById(R.id.btnOutgoingProducts);
        btnRegisterClients = findViewById(R.id.btnRegisterClients);
        btnExit = findViewById(R.id.btnExit);

        btnRegisterProduct.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_menu.this, registro.class);
            startActivity(intent);
        });

        btnViewProducts.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_menu.this, ViewProductsActivity.class);
            startActivity(intent);
        });

        btnOutgoingProducts.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_menu.this,activity_outgoin_products.class);
            startActivity(intent);
        });

        btnRegisterClients.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_menu.this, RegisterClientsActivity.class);
            startActivity(intent);
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });
    }
}
