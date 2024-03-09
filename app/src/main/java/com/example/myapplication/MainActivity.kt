package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//Halaman Awal dari Aplikasi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener{
            val intenlogin = Intent(this@MainActivity, LogInAct :: class.java)
            startActivity(intenlogin)
        }

        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister.setOnClickListener{
            val intenregist = Intent(this@MainActivity, RegistAct :: class.java)
            startActivity(intenregist)
        }
    }
}