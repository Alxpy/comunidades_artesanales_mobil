package com.eris.ecomerartesanal.Activitys;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eris.ecomerartesanal.HttpRequest.ProductoService;
import com.eris.ecomerartesanal.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eris.ecomerartesanal.Adapter.ProductoAdapter;
import com.eris.ecomerartesanal.model.ProductoModel;
import com.eris.ecomerartesanal.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductoAdapter productoAdapter;
    private List<ProductoModel> productoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cargarProductos();
    }

    private void cargarProductos() {
        ProductoService productoService = Utils.getRetrofitInstance().create(ProductoService.class);
        Call<List<ProductoModel>> call = productoService.getProductos();

        call.enqueue(new Callback<List<ProductoModel>>() {
            @Override
            public void onResponse(Call<List<ProductoModel>> call, Response<List<ProductoModel>> response) {
                if (response.isSuccessful()) {
                    productoList = response.body();

                    // Configuramos el adaptador con la lista de productos
                    productoAdapter = new ProductoAdapter(productoList);
                    recyclerView.setAdapter(productoAdapter);
                } else {
                    Toast.makeText(ProductoActivity.this, "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProductoModel>> call, Throwable t) {
                Toast.makeText(ProductoActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}