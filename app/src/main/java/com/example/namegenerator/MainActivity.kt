package com.example.namegenerator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: Button = findViewById(R.id.button)
        val chooseGender: Switch = findViewById(R.id.switch1)

        val genderTextView: TextView = findViewById(R.id.textView2)

        var gender: Char

        if (chooseGender.isChecked) {
            gender = 'M'
            genderTextView.text = "Male"
        } else {
            gender = 'F'
            genderTextView.text = "Female"
        }

        chooseGender.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked) {
                genderTextView.text = "Male"
                gender = 'M'

            } else {
                genderTextView.text = "Female"
                gender = 'F'
            }
        }

        generateButton.setOnClickListener{
            generateName(gender)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun generateName(Gender: Char) { // Function for button
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        val person = Person()
        var firstName = person.firstName
        var lastName = person.lastName

        val resultTextView: TextView = findViewById(R.id.textView)

        if (Gender == 'M') {
            firstName = person.giveMaleName()
        } else if (Gender == 'F') {
            firstName = person.giveFemaleName()
        }
        lastName = person.giveLastName()

        resultTextView.text = "$firstName $lastName"
    }
}

class Person() {
    private val maleNames = arrayOf("Andrew", "Brad", "Jose", "Cameron", "Mike", "Josh")
    private val femaleNames = arrayOf("Brianna", "Lindsey", "Bailey", "Alyssa", "Alexandra", "Sierra")
    private val lastNames = arrayOf("Johnson", "Philips", "Brooks", "Smith", "Jensen", "Rickman")

    var firstName = "My Name"
    var lastName = "is Devin"

    fun giveMaleName(): String {
        return maleNames.random() // String of male first name
    }

    fun giveFemaleName(): String {
        return femaleNames.random() // String of female first name
    }

    fun giveLastName(): String{
        return lastNames.random() // String of last name
    }
}
