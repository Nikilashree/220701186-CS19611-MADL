package com.example.temperatureconverter

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

        val txTemp = findViewById<EditText>(R.id.txTemp)
        val btCelsius = findViewById<Button>(R.id.btCelsius)
        val btFahrenheit = findViewById<Button>(R.id.btFahrenheit)
        val txResult = findViewById<TextView>(R.id.txResult)

        btCelsius.setOnClickListener {
            val input = txTemp.text.toString()
            val fahrenheit = input.toDouble()
            val celsius = (fahrenheit - 32) * 5 / 9
            txResult.text = "Result: %.2f°C".format(celsius)
        }

        btFahrenheit.setOnClickListener {
            val input = txTemp.text.toString()
            val celsius = input.toDouble()
            val fahrenheit = (celsius * 9 / 5) + 32
            txResult.text = "Result: %.2f°F".format(fahrenheit)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
