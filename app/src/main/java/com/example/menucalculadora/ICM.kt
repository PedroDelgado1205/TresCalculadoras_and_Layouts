package com.example.menucalculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class ICM : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icm)

        val etPeso: EditText = findViewById(R.id.etPeso)
        val etAltura: EditText = findViewById(R.id.etAltura)
        val bICM: Button = findViewById(R.id.BICM)
        val resultado: TextView = findViewById(R.id.TvResultadoICM)

        val btnBack3: ImageButton = findViewById(R.id.btnback3)
        btnBack3.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

        bICM.setOnClickListener {
            val pesoStr = etPeso.text.toString()
            val alturaStr = etAltura.text.toString()

            if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
                val peso = pesoStr.toDouble()
                val altura = alturaStr.toDouble()

                val imc = calcularIMC(peso, altura)
                val mensaje = interpretarResultadoIMC(imc)
                resultado.text = "IMC: $imc\n$mensaje"
            } else {
                resultado.text = "Por favor, ingrese peso y altura."
            }
        }
    }

    private fun calcularIMC(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    private fun interpretarResultadoIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Bajo peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }
}
