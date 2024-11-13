package com.eris.ecomerartesanal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.eris.ecomerartesanal.R;
import com.eris.ecomerartesanal.model.ProductoModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<ProductoModel> productos;

    public ProductoAdapter(List<ProductoModel> productos) {
        this.productos = productos;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        ProductoModel producto = productos.get(position);
        holder.productName.setText(producto.getNombre());
        holder.productPrice.setText("$" + producto.getPrecio());

        // Usar Picasso o Glide para cargar la imagen desde los bytes en el arreglo
        if (producto.getImagen() != 0) {
            // Aquí convertimos el byte[] en una imagen. Se puede usar un ImageView.setImageBitmap() si se convierte en Bitmap
            // Picasso o Glide no pueden cargar directamente los byte[] por lo que puedes convertirlos a una imagen Bitmap.
            // Ejemplo con Picasso:
            Picasso.get().load(producto.getImagen()).into(holder.productImage); // O usar un Bitmap.
        }
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productPrice;
        public ImageView productImage;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
