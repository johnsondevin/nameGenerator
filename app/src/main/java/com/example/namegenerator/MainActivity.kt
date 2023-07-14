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

        val generateButton: Button = findViewById(R.id.button) // Save button to val
        val chooseGender: Switch = findViewById(R.id.switch1) // Save switch to val

        val genderTextView: TextView = findViewById(R.id.textView2)

        var gender: Char

        if (chooseGender.isChecked) { // Check the initial state of the switch
            gender = 'M'
            genderTextView.text = "Male"
        } else {
            gender = 'F'
            genderTextView.text = "Female"
        }

        chooseGender.setOnCheckedChangeListener{_, isChecked -> // Set eventListener for switch
            if (isChecked) {
                genderTextView.text = "Male"
                gender = 'M'

            } else {
                genderTextView.text = "Female"
                gender = 'F'
            }
        }

        generateButton.setOnClickListener{
            generateName(gender) // Get new name
        }

    }

    @SuppressLint("SetTextI18n")
    private fun generateName(Gender: Char) { // Function to create new name
        val person = Person()
        var firstName = person.firstName
        var lastName = person.lastName

        val resultTextView: TextView = findViewById(R.id.textView)

        if (Gender == 'M') {
            firstName = person.giveMaleName() // Get male name
        } else if (Gender == 'F') {
            firstName = person.giveFemaleName() // Get female name
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
        return maleNames.random() // Return string of male first name
    }

    fun giveFemaleName(): String {
        return femaleNames.random() // Return string of female first name
    }

    fun giveLastName(): String{
        return lastNames.random() // Return string of last name
    }
}
