package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class WelcomePageActivity : AppCompatActivity() {

    lateinit var tvWelcome : TextView
    lateinit var tvDetails : TextView
    lateinit var bSignOut : Button


    private val dbHelper by lazy { DBHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvDetails = findViewById(R.id.tvDetails)
        bSignOut = findViewById(R.id.bSignOut)

        val intent = getIntent()
        var name = intent.getStringExtra("Name")
        var loc = intent.getStringExtra("loc")
        var num = intent.getStringExtra("num")


        Log.d("Welcome page", " details : name $name , loc $loc , num $num")


            tvWelcome.text = "Welcome $name "
            tvDetails.text = "Your number is $num, \n Your location is $loc"


        bSignOut.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}