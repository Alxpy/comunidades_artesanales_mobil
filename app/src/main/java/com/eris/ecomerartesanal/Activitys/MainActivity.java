package com.eris.ecomerartesanal.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.eris.ecomerartesanal.HttpRequest.PedidoService;
import com.eris.ecomerartesanal.R;
import com.eris.ecomerartesanal.model.Pedido;
import com.eris.ecomerartesanal.utils.Utils;
import com.google.gson.GsonBuilder;

import java.security.Policy;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // O el tipo de vista que prefieras para hacer clic
import androidx.appcompat.app.AppCompatActivity;
import com.eris.ecomerartesanal.R;

public class MainActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button openProductoActivityButton = findViewById(R.id.openProductoActivityButton);
        openProductoActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para ir de MainActivity a ProductoActivity
                Intent intent = new Intent(MainActivity.this, ProductoActivity.class);

                // Si deseas pasar datos, puedes hacerlo con putExtra
                // intent.putExtra("key", value);

                // Iniciar la actividad
                startActivity(intent);
            }
        });

        tableLayout = findViewById(R.id.tableLayout);

        Log.d("actividad", "pidiendo");
        cargarPedidos();

    }

    private void cargarPedidos() {
        PedidoService pedidoService = Utils.getRetrofitInstance().create(PedidoService.class);
        Call<List<Pedido>> call = pedidoService.getPedidos();
        call.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                if (response.isSuccessful()) {
                    List<Pedido> pedidos = response.body();
                    if (pedidos != null) {
                        for (Pedido pedido : pedidos) {
                            agregarFilaTabla(pedido);
                        }

                        // Mostrar el Toast de éxito en el hilo principal
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Pedidos cargados con éxito", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    // Si la respuesta no fue exitosa, también puedes mostrar un Toast de error
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error al cargar los pedidos", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }


            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                // Verificar si el error es por una conexión fallida o un error de otro tipo
                String errorMessage = "Error de conexión"; // Mensaje por defecto

                // Si la excepción tiene detalles, los mostramos
                if (t != null && t.getMessage() != null) {
                    errorMessage = t.getMessage();
                }

                // Mostrar el mensaje de error en un Toast, asegurándonos de que se ejecute en el hilo principal
                String finalErrorMessage = errorMessage;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), finalErrorMessage, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void agregarFilaTabla(Pedido pedido) {
        TableRow fila = new TableRow(this);

        // Crear una celda para cada campo del pedido
        TextView idPedidoTextView = new TextView(this);
        idPedidoTextView.setText(String.valueOf(pedido.getIdPedido()));
        fila.addView(idPedidoTextView);

        TextView fechaTextView = new TextView(this);
        fechaTextView.setText(pedido.getFecha());
        fila.addView(fechaTextView);

        TextView estadoTextView = new TextView(this);
        estadoTextView.setText(pedido.getEstado());
        fila.addView(estadoTextView);

        TextView totalTextView = new TextView(this);
        totalTextView.setText(String.valueOf(pedido.getTotal()));
        fila.addView(totalTextView);

        TextView idClienteTextView = new TextView(this);
        idClienteTextView.setText(String.valueOf(pedido.getIdCliente()));
        fila.addView(idClienteTextView);

        // Agregar la fila al TableLayout
        tableLayout.addView(fila);
    }

}
