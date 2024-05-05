package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityRegistBinding
import com.google.firebase.auth.FirebaseAuth

//Halaman Registrasi Aplikasi

class RegistAct : AppCompatActivity() {

    private lateinit var binding : ActivityRegistBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnReg.setOnClickListener{
            val email : String = binding.etEmail.text.toString().trim()
            val password  : String = binding.etPassword.text.toString().trim()
            val confirmPassword : String = binding.etConfirmPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.etEmail.error = "Input Email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmail.error = "Invalid Email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword){
                binding.etConfirmPassword.error = "Password harus Sama"
                binding.etConfirmPassword.requestFocus()
                return@setOnClickListener
            }
            registerUser(email,password)
        }

        binding.tvHaveAccount.setOnClickListener{
            startActivity(Intent(this, LogInAct::class.java))
        }
    }

    private fun registerUser(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful){
                Intent(this, HomeAct::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}