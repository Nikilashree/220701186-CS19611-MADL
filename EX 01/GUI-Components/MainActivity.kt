package com.example.reccolor

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val tvText2: TextView =findViewById(R.id.tvText2)
        val btFontSize: Button = findViewById(R.id.btChangeFontSize)
        val btFontcolor : Button = findViewById(R.id.btChangeFontColor)
        val btBackgroundColor : Button = findViewById(R.id.btChangeBackgroundColor)
        val linearBackground : LinearLayout = findViewById(R.id.main)
        var fontSize = 5.0f
        var fontColor = 0
        var bgColor = 0

        btFontSize.setOnClickListener{
            tvText2.textSize = fontSize
            fontSize = (fontSize+5)%50
        }
        btFontcolor.setOnClickListener{
            when(fontColor%3){
                0->tvText2.setTextColor(Color.RED)
                1->tvText2.setTextColor(Color.GREEN)
                2->tvText2.setTextColor(Color.BLUE)
            }
            fontColor++
        }
        btBackgroundColor.setOnClickListener{
            when(bgColor%3){
                0->linearBackground.setBackgroundColor(Color.RED)
                1->linearBackground.setBackgroundColor(Color.GREEN)
                2->linearBackground.setBackgroundColor(Color.BLUE)
            }
            bgColor++
        }
    }
}
