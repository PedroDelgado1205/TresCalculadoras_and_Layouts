package com.example.menucalculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class DosNumeros : AppCompatActivity() {
    private lateinit var editText: EditText
    private var operand1: Double = 0.0
    private var operator: String? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos_numeros)
        editText = findViewById(R.id.eTextResultado)

        val b0: Button = findViewById(R.id.b0)
        val b1: Button = findViewById(R.id.b1)
        val b2: Button = findViewById(R.id.b2)
        val b3: Button = findViewById(R.id.b3)
        val b4: Button = findViewById(R.id.b4)
        val b5: Button = findViewById(R.id.b5)
        val b6: Button = findViewById(R.id.b6)
        val b7: Button = findViewById(R.id.b7)
        val b8: Button = findViewById(R.id.b8)
        val b9: Button = findViewById(R.id.b9)
        val bmas: Button = findViewById(R.id.bmas)
        val bmenus: Button = findViewById(R.id.bmenos)
        val bpor: Button = findViewById(R.id.bpor)
        val bdiv: Button = findViewById(R.id.bdiv)
        val bigual: Button = findViewById(R.id.bigual)

        // Maneja la entrada de números
        val numberClickListener = { number: Int ->
            editText.append(number.toString())
        }

        b0.setOnClickListener { numberClickListener(0) }
        b1.setOnClickListener { numberClickListener(1) }
        b2.setOnClickListener { numberClickListener(2) }
        b3.setOnClickListener { numberClickListener(3) }
        b4.setOnClickListener { numberClickListener(4) }
        b5.setOnClickListener { numberClickListener(5) }
        b6.setOnClickListener { numberClickListener(6) }
        b7.setOnClickListener { numberClickListener(7) }
        b8.setOnClickListener { numberClickListener(8) }
        b9.setOnClickListener { numberClickListener(9) }

        // Maneja las operaciones
        bmas.setOnClickListener { handleOperation("+") }
        bmenus.setOnClickListener { handleOperation("-") }
        bpor.setOnClickListener { handleOperation("*") }
        bdiv.setOnClickListener { handleOperation("/") }

        // Calcula el resultado
        bigual.setOnClickListener {
            calculateResult()
        }

        val btnBakc1:ImageButton = findViewById(R.id.btnback1)
        btnBakc1.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity(menu)
        }
    }
    private fun handleOperation(operator: String) {
        this.operator = operator
        operand1 = editText.text.toString().toDouble()
        editText.text.clear()
    }

    private fun calculateResult() {
        if (operator != null) {
            val operand2 = editText.text.toString().toDouble()
            when (operator) {
                "+" -> editText.setText((operand1 + operand2).toString())
                "-" -> editText.setText((operand1 - operand2).toString())
                "*" -> editText.setText((operand1 * operand2).toString())
                "/" -> {
                    if (operand2 != 0.0) {
                        editText.setText((operand1 / operand2).toString())
                    } else {
                        editText.setText("Error")
                    }
                }
            }
            operator = null
        }
    }
}