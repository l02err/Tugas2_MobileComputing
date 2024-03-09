package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//Halaman Registrasi Aplikasi

class RegistAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        val btnReg = findViewById<Button>(R.id.btn_reg)
        btnReg.setOnClickListener{
            val intenreg = Intent(this@RegistAct, LogInAct :: class.java)
            startActivity(intenreg)
            finish()
        }

        val tvHaveAccount = findViewById<TextView>(R.id.tv_have_account)
        tvHaveAccount.setOnClickListener{
            val intenlogin = Intent(this@RegistAct, LogInAct :: class.java)
            startActivity(intenlogin)
        }
    }
}