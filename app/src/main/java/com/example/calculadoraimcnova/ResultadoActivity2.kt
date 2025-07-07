package com.example.calculadoraimcnova

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity2 : AppCompatActivity() {

    private lateinit var textPeso:TextView
    private lateinit var textAltura:TextView
    private lateinit var textResultado:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textPeso = findViewById(R.id.textPeso)
        textAltura = findViewById(R.id.textAltura)
        textResultado = findViewById(R.id.textResultado)

        val bundle = intent.extras //RECUPEANDO OS VALORES DIGITADOS

        if (bundle!=null){//

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso Kg"
            textAltura.text = "Peso informado $altura Kg"

            val imc = peso/ (altura * altura)// FAZENDO O CALCULO
            val resultado =if (imc< 18.5){
                "Baixo"
            }else if (imc in 18.5..24.9){
                "Normal"
            }else if (imc in 25.0 ..29.9 ){
                  "Sobrepeso"
            }else{
                 "Obesidade"
            }
            textResultado.text = resultado
        }
    }
}