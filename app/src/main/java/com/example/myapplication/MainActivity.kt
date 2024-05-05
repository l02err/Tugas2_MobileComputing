package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

//Halaman Awal dari Aplikasi

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intentLogin = Intent(this, LogInAct::class.java)
            startActivity(intentLogin)
        }

        binding.btnRegister.setOnClickListener{
            val intentRegister = Intent(this, RegistAct::class.java)
            startActivity(intentRegister)
        }
    }
}