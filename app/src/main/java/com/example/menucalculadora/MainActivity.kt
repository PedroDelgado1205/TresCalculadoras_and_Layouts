package com.example.menucalculadora

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnCalculadora: Button = findViewById(R.id.Btn2N)
        BtnCalculadora.setOnClickListener {
            val ventana2n = Intent(this, DosNumeros::class.java)
            startActivity(ventana2n)
        }

        val BtnFactorial: Button = findViewById(R.id.BtnFac)
        BtnFactorial.setOnClickListener {
            val ventanaFac = Intent(this, Factorial::class.java)
            startActivity(ventanaFac)
        }

        val BtnICM: Button = findViewById(R.id.BtnIMC)
        BtnICM.setOnClickListener {
            val ventanaICM = Intent(this, ICM::class.java)
            startActivity(ventanaICM)
        }

        val btnLinear: Button = findViewById(R.id.btnLinear)
        btnLinear.setOnClickListener {
            val ventanaLinear = Intent(this, LinearActivity::class.java)
            startActivity(ventanaLinear)
        }
        val btnFrame: Button = findViewById(R.id.btnFrame)
        btnFrame.setOnClickListener {
            val ventanaFrame = Intent(this, FrameActivity::class.java)
            startActivity(ventanaFrame)
        }
        val btnConstraint: Button = findViewById(R.id.btnConstraint)
        btnConstraint.setOnClickListener {
            val ventanaConstraint = Intent(this, ConstraintActivity::class.java)
            startActivity(ventanaConstraint)
        }
    }
}