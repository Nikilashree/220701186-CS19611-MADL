package com.example.loginvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginvalidation.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etText: EditText = findViewById(R.id.etText)
        val etPass: EditText = findViewById(R.id.etPass)
        val btDisplay: Button = findViewById(R.id.btDisplay)
        var errorMessage = ""
        btDisplay.setOnClickListener {
            val username = etText.text.toString()
            val id = etPass.text.toString()
            errorMessage="Successfully Logged In"

            if (username.any { !((it in 'A'..'Z') || (it in 'a'..'z')) }) {
                errorMessage = "Username should contain only alphabets."
            }

            if (id.length != 4 || id.any { it !in '0'..'9' }) {
                errorMessage = "ID should be exactly 4 numeric digits."
            }

            val alertDialog = AlertDialog.Builder(this)
                .setTitle("MAD Lab")
                .setMessage(errorMessage)
                .setPositiveButton("Ok") { dialog, which ->
                    Toast.makeText(this, "You clicked Ok", Toast.LENGTH_LONG).show()
                }
                .setNeutralButton("Cancel") { dialog, which ->
                    Toast.makeText(this, "You clicked Cancel", Toast.LENGTH_LONG).show()
                }
                .create()
            alertDialog.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
