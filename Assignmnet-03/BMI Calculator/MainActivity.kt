package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txHeight = findViewById<EditText>(R.id.txHeight)
        val txWeight = findViewById<EditText>(R.id.txWeight)
        val btCalculate = findViewById<Button>(R.id.btCalculate)
        val txBMI = findViewById<TextView>(R.id.txBMI)

        btCalculate.setOnClickListener {
            val weight = txWeight.text.toString().toDouble()
            val height = txHeight.text.toString().toDouble()
            val metres = height / 100
            val ans = weight / (metres * metres)
            val round = String.format("%.1f", ans).toDouble()

            txBMI.text = "BMI is $round kg/m²"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
