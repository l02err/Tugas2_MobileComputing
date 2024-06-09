package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDetailBinding

class DetailAct : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intss = intent
        var nameT = intss.getStringExtra("NAMET")
        var desT = intss.getStringExtra("DESCRIT")
        var veT = intss.getStringExtra("VET")
        var imgT = intss.getStringExtra("IMGURI")

        binding.tvJenis.text = nameT
        binding.tvDetal.text = desT
        binding.tvVersi.text = veT
        binding.ivGambar.loadImage(imgT)

    }
}