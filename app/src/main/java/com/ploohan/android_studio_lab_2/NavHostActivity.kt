package com.ploohan.android_studio_lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NavHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)
        val changeView = findViewById<Button>(R.id.changeFragmentBtn)

        changeView.setOnClickListener {
            supportFragmentManager.beginTransaction()
            .replace(R.id.userActivityFragment, RecyclerViewActivityFragment()).commit()
            changeView.visibility = View.GONE
        }
    }
}