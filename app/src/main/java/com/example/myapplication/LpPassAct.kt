package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLppassBinding
import com.google.firebase.auth.FirebaseAuth

//Halaman Lupa Password

class LpPassAct : AppCompatActivity() {
    private lateinit var binding: ActivityLppassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lppass)

        binding = ActivityLppassBinding.inflate(layoutInflater)

        binding.btnRstPass.setOnClickListener{
            val email : String = binding.mskEmail.text.toString().trim()
            if (email.isEmpty()){
               binding.mskEmail.error = "Masukkan Email"
               binding.mskEmail.requestFocus()
               return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.mskEmail.error = "Email Salah"
                binding.mskEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this, "Cek Email untuk Reset Password", Toast.LENGTH_SHORT).show()
                    Intent(this, LogInAct::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        finish()
                    }
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}