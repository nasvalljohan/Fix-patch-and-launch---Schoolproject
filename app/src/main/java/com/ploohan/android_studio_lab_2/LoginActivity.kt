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
        // RecyclerView added in fragment, hardcoded values printed from loop.

        val emailText = findViewById<EditText>(R.id.EmailText)
        val passWordText = findViewById<EditText>(R.id.pwText)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val listMailAddress = ArrayList<String>()
        val listPw = ArrayList<String>()

        //Users
        listMailAddress.add("johan@gmail.com")   //0
        listMailAddress.add("ploo@gmail.com")    //1
        listMailAddress.add("johanna@gmail.com") //2
        listMailAddress.add("admin")             //3

        listPw.add("johan")                      //0
        listPw.add("ploo")                       //1
        listPw.add("johanna")                    //2
        listPw.add("admin")                      //3


        loginBtn.setOnClickListener {
            val emailString = emailText.text.toString()
            val passwordString = passWordText.text.toString()

            if (listMailAddress.contains(emailString) && listPw.contains(passwordString)) {
                if (listMailAddress.indexOf(emailString) == listPw.indexOf(passwordString)) {
                    val intent = Intent(this, NavHostActivity::class.java).apply {
                        putExtra("textMsg", emailString)
                    }
                    val text = "You are now logged in, welcome"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()

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



