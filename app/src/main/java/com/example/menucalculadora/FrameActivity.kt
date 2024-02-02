package com.example.menucalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        val atras : ImageView = findViewById(R.id.ivAtras)
        atras.setOnClickListener {
            finish()
        }
    }
}