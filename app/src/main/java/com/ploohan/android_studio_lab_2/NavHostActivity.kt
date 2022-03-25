package com.ploohan.android_studio_lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class NavHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        //Value we want to change
        val textMsg = findViewById<TextView>(R.id.textMsg)

        //Value passed
        val name = intent.getStringExtra("textMsg")

        textMsg.text = "Welcome $name"
    }
}