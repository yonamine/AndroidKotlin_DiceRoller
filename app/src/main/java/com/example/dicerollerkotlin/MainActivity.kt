package com.example.dicerollerkotlin

/**
 * 'var': general variable
 * 'val': constant variable (cannot assign multiple times) and can be initialized only single time.
 *        It is called as 'immutable variable'
 * 'lateinit var ...': member is declared in the class and it will be initialized outside of the
 *                     constructor
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById<Button>(R.id.buttonRoll)
        rollButton.setOnClickListener { rollDice() }

        diceImage = findViewById<ImageView>(R.id.dice_image)

    }

    private fun rollDice() {
        val randomInt = (1..6).random()

        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        Toast.makeText(this, "Dice has been rolled!", Toast.LENGTH_SHORT).show()
    }
}