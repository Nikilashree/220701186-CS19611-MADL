package com.example.techlounge

import android.os.Bundle
import android.widget.Button
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
        val txCounter: TextView=findViewById(R.id.txCounter)
        val btIncrement : Button = findViewById(R.id.btCheckIn)
        val btDecrement : Button = findViewById(R.id.btCheckOut)
        var counter = 0
        txCounter.text = counter.toString()
        btIncrement.setOnClickListener {
            counter++
            txCounter.text = counter.toString()
        }
        btDecrement.setOnClickListener {
            if(counter>0) {
                counter--
            }
            txCounter.text = counter.toString()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
