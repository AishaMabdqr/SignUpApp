package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    lateinit var eName : EditText
    lateinit var eLoc : EditText
    lateinit var ePass : EditText
    lateinit var eNum : EditText
    lateinit var bSignUp2 : Button


    private val dbHelper by lazy { DBHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        eName = findViewById(R.id.eName)
        eLoc = findViewById(R.id.eLocation)
        ePass = findViewById(R.id.ePass)
        eNum = findViewById(R.id.eNumber)
        bSignUp2 = findViewById(R.id.bSignUp2)


//        Log.d("SignUp page", " details : name $name , loc $loc , num $num")


        bSignUp2.setOnClickListener {
            if (eName.text.toString() != null && eLoc.text.toString() != "" && eNum.text.toString() != "" && ePass.text.toString() != "") {
                saveData()
                val intent = Intent(this, WelcomePageActivity::class.java)
                intent.putExtra("Name", eName.text.toString())
                intent.putExtra("loc", eLoc.text.toString())
                intent.putExtra("num", eNum.text.toString())
                startActivity(intent)
            } else {
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveData(){
        var pass = ePass.text.toString()
        dbHelper.saveData(Details(0, eName.text.toString(), eLoc.text.toString(),  eNum.text.toString(),pass.toInt()))
    }
}