package com.ploohan.android_studio_lab_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Changed setContentView to activity_login from _main
        // Missing <acivity> in androidmanifest, added.
        // Constraints in activity_login, height and width set, previous 0dp.
        // Changed ID and text on button
        // Added hint and input-type to editText
        // Sent emailtext to mainactivity with intent, added to textview.
        // Arraylist for email & password, checking if pw & email matches.

        val emailText = findViewById<EditText>(R.id.EmailText)
        val passWord = findViewById<EditText>(R.id.pwText)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val userMailAddress = ArrayList<String>()
        val userPw = ArrayList<String>()

        userMailAddress.add("johan@gmail.com") // 0
        userMailAddress.add("ploo@gmail.com") // 1
        userMailAddress.add("johanna@gmail.com") // 2
        userMailAddress.add("1")

        userPw.add("johan") //0
        userPw.add("ploo")  //1
        userPw.add("johanna")   //2
        userPw.add("1")


        loginBtn.setOnClickListener {
            val emailString = emailText.text.toString()
            val passwordString = passWord.text.toString()

            if (userMailAddress.contains(emailString) && userPw.contains(passwordString)) {
                if (userMailAddress.indexOf(emailString) == userPw.indexOf(passwordString)) {
                    val intent = Intent(this, MainActivity::class.java).apply {
                        putExtra("textMsg", emailString)
                    }
                    startActivity(intent)
                } else {
                    val text = "Email and password does not match"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()}

            } else {
                val text = "The Email or Password does not exist"
                val duration = Toast.LENGTH_LONG
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
    }
    }



