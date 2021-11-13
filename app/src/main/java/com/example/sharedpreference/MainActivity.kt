package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/
class MainActivity : AppCompatActivity() {
    val sharedPrefFile = "Kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputAge = findViewById<EditText>(R.id.editAge)
        val inputFirstName = findViewById<EditText>(R.id.firstName)
        val inputLastName = findViewById<EditText>(R.id.lastName)
        val outputAge = findViewById<TextView>(R.id.textViewShowAge)
        val outputFirstName = findViewById<TextView>(R.id.textViewShowFirstName)
        val outputLastName = findViewById<TextView>(R.id.textViewShowLastName)
        val btnSave = findViewById<Button>(R.id.Save)
        val btnView = findViewById<Button>(R.id.View)
        val btnClear = findViewById<Button>(R.id.clear)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        btnSave.setOnClickListener(View.OnClickListener {
            val age = Integer.parseInt(inputAge.text.toString())
            val namefirst: String = inputFirstName.text.toString()
            val namelast: String = inputLastName.text.toString()
            val editor = sharedPreferences.edit()
            editor.putInt("age_key", age)
            editor.putString("nameFirst_key", namefirst)
            editor.putString("nameLast_key", namelast)
            editor.apply()
            editor.commit()
            btnView.setOnClickListener {
                val sharedAgeValue = sharedPreferences.getInt("age_key", 0)
                val sharedNameFirstValue = sharedPreferences.getString("nameFirst_Key", "Handy")
                val sharedNameLastValue = sharedPreferences.getString("nameLast_key", "Opinion")
                if (sharedAgeValue.equals(0) && sharedNameFirstValue.equals("Handy")){
                outputFirstName.setText("FirstName:${sharedNameFirstValue}").toString()
                outputAge.setText("default Age: ${sharedAgeValue.toString()}")
            } else if(sharedAgeValue.equals(0) && sharedNameLastValue.equals("Opinion")){
                outputLastName.setText("Last Name: ${sharedNameLastValue}").toString()
                outputAge.setText("defaultAge:${sharedAgeValue.toString()}")

            } else if (sharedAgeValue.equals(0) && sharedNameFirstValue.equals("Handy") && sharedNameLastValue.equals("Opinion")){
                outputFirstName.setText("First Name: ${sharedNameFirstValue}").toString()
                outputLastName.setText("LastName:${sharedNameLastValue}").toString()
                outputAge.setText("default Age: ${sharedAgeValue.toString()}")
            } else {
                outputFirstName.setText(sharedNameFirstValue).toString()
                outputLastName.setText(sharedNameLastValue).toString()
                outputAge.setText(sharedAgeValue.toString())
            }
            }
             btnClear.setOnClickListener(View.OnClickListener {
                 val editor = sharedPreferences.edit()
                 editor.clear()
                 editor.apply()
                 outputFirstName.setText("").toString()
                 outputLastName.setText("").toString()
                 outputAge.setText("")

             })
        })
    }
}