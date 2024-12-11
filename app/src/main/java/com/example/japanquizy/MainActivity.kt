package com.example.japanquizy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.japanquizy.databinding.ActivityMainBinding
import java.lang.Boolean.FALSE

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }
}

const val TAG = "chura"
val kanasList = listOf(
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


