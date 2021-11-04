package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    lateinit var ePass : EditText
    lateinit var eNum : EditText
    lateinit var bSignIn2 : Button


    private val dbHelper by lazy { DBHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        ePass = findViewById(R.id.ePassSignin)
        eNum = findViewById(R.id.eNumSignin)
        bSignIn2 = findViewById(R.id.bSignIn2)

        bSignIn2.setOnClickListener{
            if ( eNum.text.toString() != "" && ePass.text.toString() != ""){
            var pass = ePass.text.toString()
            var num = eNum.text.toString()

           var response =  dbHelper.checkCred(num)
                Log.d("SignIn", "outside if $response")

            if (response == -1){
                Toast.makeText(applicationContext, "Mobile number or Password is incorrect", Toast.LENGTH_LONG).show()
                Log.d("SignIn", "pk $response")

            }else {
                val intent = Intent(this, WelcomePageActivity::class.java)
                var info = dbHelper.retrieveData(response)
                intent.putExtra("Name",info.Name)
                intent.putExtra("loc",info.Location)
                intent.putExtra("num",info.Mobile)
                Log.d("SignIn", "pk $response")
                startActivity(intent)
            }
    }
        }

}
}
