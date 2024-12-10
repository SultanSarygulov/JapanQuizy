package com.example.japanquizy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.japanquizy.databinding.ActivityMainBinding
import java.lang.Boolean.FALSE

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var buttons: List<AppCompatButton>
    private var score: Int = 0
    private val kanasList = listOf(
        Kana("あ", "a"), Kana("い", "i"), Kana("う", "u"), Kana("え", "e"), Kana("お", "o"),
        Kana("か", "ka"), Kana("き", "ki"), Kana("く", "ku"), Kana("け", "ke"), Kana("こ", "ko"),
        Kana("さ", "sa"), Kana("し", "shi"), Kana("す", "su"), Kana("せ", "se"), Kana("そ", "so"),
        Kana("た", "ta"), Kana("ち", "chi"), Kana("つ", "tsu"), Kana("て", "te"), Kana("と", "to"),
        Kana("な", "na"), Kana("に", "ni"), Kana("ぬ", "nu"), Kana("ね", "ne"), Kana("の", "no"),
        Kana("は", "ha"), Kana("ひ", "hi"), Kana("ふ", "fu"), Kana("へ", "he"), Kana("ほ", "ho"),
        Kana("ま", "ma"), Kana("み", "mi"), Kana("む", "mu"), Kana("め", "me"), Kana("も", "mo"),
        Kana("や", "ya"), Kana("ゆ", "yu"), Kana("よ", "yo"),
        Kana("ら", "ra"), Kana("り", "ri"), Kana("る", "ru"), Kana("れ", "re"), Kana("ろ", "ro"),
        Kana("わ", "wa"), Kana("を", "wo"), Kana("ん", "n")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttons = listOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4
        )

        setQuiz()

        binding.nextButton.setOnClickListener {

            resetButtons(buttons)
            setQuiz()
        }
    }

    private fun setQuiz() {
        val chosenKana = kanasList.random()

        val correctAnswer = chosenKana.sound
        val wrongAnswers = kanasList.shuffled().take(3).map { it.sound }
        val answers = (wrongAnswers + correctAnswer).shuffled()

        binding.letter.text = chosenKana.letter

        buttons.zip(answers).forEach { (button, answer) ->
            button.text = answer
        }

        buttons.forEach {button ->
            button.setOnClickListener {
                //When incorrect
                when(button.text){

                    correctAnswer -> {

                        disableButtons(buttons)

                        button.setBackgroundColor(Color.GREEN)
                        button.setTextColor(Color.WHITE)

                        score += 1
                        binding.score.text = "Score $score"
                    }
                    //When incorrect
                    else -> {
                        disableButtons(buttons)

                        button.setBackgroundColor(Color.RED)
                        button.setTextColor(Color.WHITE)

                        buttons.find { it.text == correctAnswer }?.apply {
                            setBackgroundColor(Color.GREEN)
                            setTextColor(Color.WHITE)
                        }

                        score -= 1
                        binding.score.text = "Score $score"
                    }
                }
            }
        }
    }

    private fun disableButtons(buttons: List<Button>) {
        Log.d("chura", "disableButtons")
        buttons.forEach { button ->
            button.isClickable = false
        }
    }

    private fun enableButtons(buttons: List<Button>) {
        Log.d("chura", "disableButtons")
        buttons.forEach { button ->
            button.isClickable = true
        }
    }

    private fun resetButtons(buttons: List<Button>) {
        buttons.forEach { button ->
            button.setBackgroundColor(Color.LTGRAY)
            button.setTextColor(Color.BLACK)

        }

        enableButtons(buttons)

    }
}

const val TAG = "chura"

