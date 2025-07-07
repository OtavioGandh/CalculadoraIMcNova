package com.example.calculadoraimcnova

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular:Button
    private lateinit var edtPeso:EditText
    private lateinit var edtAltura:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        btnCalcular = findViewById(R.id.btnCalcular)
        edtPeso = findViewById(R.id.edtPeso)
        edtAltura = findViewById(R.id.edtAltura)

        btnCalcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity2::class.java)

            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()

            if (peso.isNotEmpty()&& altura.isNotEmpty()){    // SO EVIARA PARA PROX TELA, SE OS DADOS NAO ESTIVEREM VAZIOS

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }
        }
    }
