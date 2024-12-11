package com.example.japanquizy

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.example.japanquizy.databinding.ActivityMainBinding
import com.example.japanquizy.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private lateinit var buttons: List<AppCompatButton>
    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        binding.tableButton.setOnClickListener {

            findNavController().navigate(R.id.action_quizFragment_to_tableFragment)
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