package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//Halaman Lupa Password

class LpPassAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lppass)


        val btnRstPass = findViewById<Button>(R.id.btn_rst_pass)
        btnRstPass.setOnClickListener{
            val intenreset = Intent(this@LpPassAct, LogInAct :: class.java)
            startActivity(intenreset)
            finish()
        }

}
}