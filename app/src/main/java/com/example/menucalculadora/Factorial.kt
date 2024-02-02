package com.example.menucalculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class Factorial : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial)

        val etFac: EditText = findViewById(R.id.eTextResultadoFac)
        val btCalcular: Button = findViewById(R.id.bFac)
        val result: TextView = findViewById(R.id.TvResuldato)

        val btnBack2: ImageButton = findViewById(R.id.btnback2)
        btnBack2.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }

        btCalcular.setOnClickListener {
            val inputValue = etFac.text.toString().toIntOrNull()

            if (inputValue != null) {
                val factorialResult = calculateFactorial(inputValue)
                result.text = "Factorial: $factorialResult"
            } else {
                result.text = "Por favor, ingrese un número válido."
            }
        }
    }

    private fun calculateFactorial(number: Int): Long {
        return if (number == 0 || number == 1) {
            1
        } else {
            var result = 1L
            for (i in 2..number) {
                result *= i
            }
            result
        }
    }
}
