package com.login.chayo;

import static com.login.chayo.R.id.recyclerViewProducts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        // Inicializamos el RecyclerView
       // recyclerView = findViewById(recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Llenamos la lista de productos (esto sería dinámico con una base de datos en un proyecto real)
        productList = new ArrayList<>();
        productList.add(new Product("Producto A", 10));
        productList.add(new Product("Producto B", 5));
        productList.add(new Product("Producto C", 20));

        // Configuramos el adaptador
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }
}
