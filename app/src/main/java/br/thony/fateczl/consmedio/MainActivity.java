package br.thony.fateczl.consmedio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView lblResultado;
    private EditText txtConsumo;
    private EditText txtLitroTanque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lblResultado = findViewById(R.id.lblResultado);
        lblResultado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        txtConsumo = findViewById(R.id.txtConsumo);
        txtConsumo.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        txtLitroTanque = findViewById(R.id.txtLitroTanque);
        txtLitroTanque.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(e -> calcular());

    }

    private void calcular() {
        float consumo = Float.parseFloat(txtConsumo.getText().toString());
        float litroTanque = Float.parseFloat(txtLitroTanque.getText().toString());
        float autonomia = litroTanque / consumo;

        if (consumo == 0) {
            lblResultado.setText("Valores inválidos");
        } else if (autonomia >= 0 || consumo > 0){
            lblResultado.setText(autonomia + " Horas de autonomia");
        } else {
            lblResultado.setText("Valores inválidos");
        }
    }
}