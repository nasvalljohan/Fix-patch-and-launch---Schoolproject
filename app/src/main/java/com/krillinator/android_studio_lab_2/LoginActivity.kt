package com.krillinator.android_studio_lab_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Loaded LoginActivity")

        /* TODO - Add missing LOGIN button to activity_login.xml */
        /* TODO - Input type should be: Password and Email types. (check XML)   */
        /* TODO - .apply to send user information from input field BACK to MainActivity */
    }
}