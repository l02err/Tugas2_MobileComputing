package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

//Halaman LogIn Aplikasi

class LogInAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val tvHaventAccount = findViewById<TextView>(R.id.tv_havent_account)
        tvHaventAccount.setOnClickListener{
            val intenregi = Intent(this@LogInAct, RegistAct :: class.java)
            startActivity(intenregi)
        }

        val tvLupaPw = findViewById<TextView>(R.id.tv_lupa_pw)
        tvLupaPw.setOnClickListener {
            val intenlppass = Intent(this@LogInAct,LpPassAct :: class.java)
            startActivity(intenlppass)
        }


    }
}