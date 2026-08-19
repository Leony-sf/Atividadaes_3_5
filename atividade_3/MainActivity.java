package com.example.saudacao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvImc, tvClassificacaoImc;
    Button bntClassificarImc;
    EditText edtPeso, edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        try{
            tvImc = (TextView) findViewById(R.id.lblImc);
            tvClassificacaoImc = (TextView) findViewById(R.id.lblClassificacaoImc);

            bntClassificarImc = (Button) findViewById(R.id.cmdClassificarIMC);

            edtPeso = (EditText) findViewById(R.id.txtPeso);
            edtAltura = (EditText) findViewById(R.id.txtAltura);

            bntClassificarImc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double peso, altura, imc;
                    String classificacaoImc;
                    peso = Double.parseDouble(edtPeso.getText().toString());
                    altura = Double.parseDouble(edtAltura.getText().toString());
                    imc = peso /Math.pow(altura,2);

                    if (imc <18.9) {
                        classificacaoImc = "Abaixo do peso";
                    } else if ((imc >18.9)&&(imc<=24.9)){
                        classificacaoImc = "Pessoa com Peso NORMAL";
                    } else if ((imc>24.9)&&(imc <=29.9)){
                        classificacaoImc = "Pessoa com SOBREPESO";
                    }else{
                        classificacaoImc = "Pessoa OBESA";
                    }
                    tvImc.setText(String.format("%.2f", imc));
                    tvClassificacaoImc.setText((classificacaoImc));
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}