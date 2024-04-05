package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar : ImageView = findViewById(R.id.iv_gambar)
        val jenis : TextView = findViewById(R.id.tv_jenis)
        val versi : TextView = findViewById(R.id.tv_versi)
        val detal : TextView = findViewById(R.id.tv_detal)

        val bundle: Bundle?=intent.extras
        val bJenis = bundle!!.getString("idjenis")
        val bGambar = bundle.getInt("idgambar")
        val bVersi = bundle.getString("idversi")
        val bDetal = bundle.getString("iddetal")

        gambar.setImageResource(bGambar)
        jenis.text = bJenis
        versi.text = bVersi
        detal.text = bDetal

    }
}