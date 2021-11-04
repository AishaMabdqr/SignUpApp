package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var bSignIn : Button
    lateinit var bSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bSignIn = findViewById(R.id.bSignIn)
        bSignUp = findViewById(R.id.bSignUp)

        bSignUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

        bSignIn.setOnClickListener{
            val intent = Intent(this, SignInActivity ::class.java)
            startActivity(intent)
        }
    }
}