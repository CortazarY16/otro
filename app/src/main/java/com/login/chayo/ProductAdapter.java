package com.login.chayo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productList;

    // Constructor
    public ProductAdapter(ArrayList<Product> productList) {
        this.productList = productList;
    }

    // Crea la vista de cada ítem
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    // Vincula los datos con las vistas
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductQuantity.setText("Cantidad: " + product.getQuantity());
    }

    // Devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return productList.size();
    }

    // Clase interna para el ViewHolder
    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName, tvProductQuantity;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductQuantity = itemView.findViewById(R.id.tvProductQuantity);
        }
    }
}
