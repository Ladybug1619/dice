package com.example.cube3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    //роллит кубик и отображает результат на экране
    private fun rollDice() {
        //создание 6-гранного кубика  и его бросок
        val dice = Dice(6);
        val diceRoll = dice.roll()

        //нахождение ImageView  в layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //определение id картинки кубика в зависимости от броска
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Обновление картинки кубика на экране
        diceImage.setImageResource(drawableResource)
        //Обновление описания картинки
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides + 1).random();
    }
}