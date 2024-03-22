package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

//Halaman Home Aplikasi

class HomeAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnLogout = findViewById<Button>(R.id.btn_logout)
        btnLogout.setOnClickListener{
            val intenlogout = Intent(this@HomeAct, MainActivity :: class.java)
            startActivity(intenlogout)
            finish()
        }

        val btnCamera = findViewById<Button>(R.id.btn_camera)
        btnCamera.setOnClickListener{
            val intencam = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(intencam)
        }


        val btnLokasi = findViewById<Button>(R.id.btn_lokasi)
        btnLokasi.setOnClickListener{
            val et_lokasi = findViewById<EditText>(R.id.et_lokasi)
            val intenlokasi = Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + et_lokasi.text))
            startActivity(intenlokasi)
        }


    }
}