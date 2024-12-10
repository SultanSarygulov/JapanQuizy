package com.example.japanquizy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.japanquizy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttons = listOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                when (button.id) {
                    binding.button1.id -> {
                        if (button.currentTextColor == Color.GREEN) {

                            resetButtons(buttons)
                        } else {
                            resetButtons(buttons)
                            button.setBackgroundColor(Color.GREEN)
                            button.setTextColor(Color.WHITE)
                        }
                    }
                    else -> {
//                        resetButtons(buttons)
                        button.setBackgroundColor(Color.RED)
                        button.setTextColor(Color.WHITE)

                        binding.button1.setBackgroundColor(Color.GREEN)
                        binding.button1.setTextColor(Color.WHITE)
                    }
                }
            }
        }
    }

    private fun resetButtons(buttons: List<Button>) {
        buttons.forEach { button ->
            i += 1
            Log.d("chura", "resetButtons $i")
            button.setBackgroundColor(Color.LTGRAY)
            button.setTextColor(Color.BLACK)

        }

    }
}

var i: Int = 0