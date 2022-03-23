package com.ploohan.android_studio_lab_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/* TODO READ THE README FILE FIRST */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Missing comment on TODO,
        //  Button imported,
        //  Added ID on button and changed findViewByID.
        //  Added constraints to XML.

        val gotoLogin = findViewById<Button>(R.id.gotoLogin)

        val textMsg = findViewById<TextView>(R.id.welcomeMsg1)
        val name = intent.getStringExtra("textMsg")

        if (name != null){
         textMsg.text = "Welcome $name"
         val text = "You are now logged in!"
         val duration = Toast.LENGTH_LONG
         val toast = Toast.makeText(applicationContext, text, duration)
         toast.show()
      }



        // TODO("Create Intent to navigate")

        gotoLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}