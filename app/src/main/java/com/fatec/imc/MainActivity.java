package com.fatec.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText editTextPeso, editTextAltura;
    RadioGroup radioGroupSexo;
    RadioButton radioButtonMasculino, radioButtonFeminino;
    Button buttonCalcular;
    TextView textViewIMC, textViewClassificacao, textViewObservacao;

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
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewIMC = findViewById(R.id.textViewIMC);
        textViewClassificacao = findViewById(R.id.textViewClassificacao);
        textViewObservacao = findViewById(R.id.textViewObservacao);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }
    private void calcularIMC() {
        // Obter valores dos campos de entrada
        double peso = Double.parseDouble(editTextPeso.getText().toString());
        double altura = Double.parseDouble(editTextAltura.getText().toString());
        boolean sexoMasculino = radioButtonMasculino.isChecked();

        // Calcular IMC
        double imc = peso / (altura * altura);

        // Classificar IMC
        String classificacao;
        String observacao;

        if (sexoMasculino) {
            if (imc >= 43) {
                classificacao = "Obesidade Mórbida";
                observacao = "Seu IMC está acima do recomendado para homens.";
            } else if (imc >= 30) {
                classificacao = "Obesidade Moderada";
                observacao = "Seu IMC está acima do recomendado para homens.";
            } else if (imc >= 25) {
                classificacao = "Obesidade Leve";
                observacao = "Seu IMC está acima do recomendado para homens.";
            } else if (imc >= 20) {
                classificacao = "Normal";
                observacao = "Seu IMC está dentro da faixa normal para homens.";
            } else {
                classificacao = "Abaixo do Normal";
                observacao = "Seu IMC está abaixo do recomendado para homens.";
            }
        } else {
            if (imc >= 39) {
                classificacao = "Obesidade Mórbida";
                observacao = "Seu IMC está acima do recomendado para mulheres.";
            } else if (imc >= 29) {
                classificacao = "Obesidade Moderada";
                observacao = "Seu IMC está acima do recomendado para mulheres.";
            } else if (imc >= 24) {
                classificacao = "Obesidade Leve";
                observacao = "Seu IMC está acima do recomendado para mulheres.";
            } else if (imc >= 19) {
                classificacao = "Normal";
                observacao = "Seu IMC está dentro da faixa normal para mulheres.";
            } else {
                classificacao = "Abaixo do Normal";
                observacao = "Seu IMC está abaixo do recomendado para mulheres.";
            }
        }

        // Exibir resultados
        textViewIMC.setText("Seu IMC: " + String.format("%.2f", imc));
        textViewClassificacao.setText("Classificação: " + classificacao);
        textViewObservacao.setText(observacao);
    }

}