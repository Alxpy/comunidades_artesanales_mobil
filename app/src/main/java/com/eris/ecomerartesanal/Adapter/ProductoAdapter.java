package com.eris.ecomerartesanal.Adapter;

import android.util.Log;
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
    private static final String IMAGE_BASE_URL = "http://192.168.1.100:3000/images/";

    // Etiqueta para los Logs
    private static final String TAG = "ProductoAdapter";

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

        // Agregar Log para verificar si la imagen está siendo correctamente procesada
        String imageName = producto.getImagen();
        Log.d(TAG, "Procesando imagen para el producto: " + producto.getNombre() + " con nombre de imagen: " + imageName);

        if (imageName != null && !imageName.isEmpty()) {
            String imageUrl = IMAGE_BASE_URL + imageName;
            Log.d(TAG, "URL de la imagen: " + imageUrl);

            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_empty_foreground) // Imagen de reemplazo mientras carga
                    .error(R.drawable.ic_launcher_foreground) // Imagen de error si la carga falla
                    .into(holder.productImage, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d(TAG, "La imagen se cargó correctamente.");
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e(TAG, "Error al cargar la imagen: " + e.getMessage(), e);
                        }
                    });
        } else {
            Log.w(TAG, "El nombre de la imagen es nulo o vacío para el producto: " + producto.getNombre());
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
