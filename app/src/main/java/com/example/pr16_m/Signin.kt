package com.example.pr16_m

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.pr16_m.R.id.*

class Signin : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)


    }
    fun signin(view: View) {
        if (email.text.toString() == "ekts" && password.text.toString() == "ekts2024") {
            val intent = Intent(this, Splashscreen::class.java)
            startActivity(intent)
        }
        else
            Toast.makeText(this, R.string.par, Toast.LENGTH_SHORT).show()
    }
}