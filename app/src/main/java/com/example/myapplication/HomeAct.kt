package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

//Halaman Home Aplikasi

class HomeAct : AppCompatActivity() {

    private lateinit var adrdRecyclerView: RecyclerView
    private lateinit var namaList: MutableList<Img>
    private lateinit var adrdAdapter: MyAdapter
    private lateinit var binding: ActivityHomeBinding
    private var mStorage:FirebaseStorage? = null
    private var mDatabaseRef:DatabaseReference? = null
    private var mDBListener:ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adrdRecyclerView = findViewById(R.id.andrRV)
        adrdRecyclerView.setHasFixedSize(true)
        adrdRecyclerView.layoutManager = LinearLayoutManager(this@HomeAct)
        binding.prgsbar.visibility = View.VISIBLE
        namaList = ArrayList()
        adrdAdapter = MyAdapter(this@HomeAct,namaList)
        adrdRecyclerView.adapter = adrdAdapter

        mStorage = FirebaseStorage.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Android")
        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.e("HomeAct", "DatabaseError: ${error.message}")
                Toast.makeText(this@HomeAct, error.message, Toast.LENGTH_SHORT).show()
                binding.prgsbar.visibility = View.INVISIBLE
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("HomeAct", "DataSnapshot: $snapshot") // Log the snapshot for debugging
                namaList.clear()
                for (teacherSnapshot in snapshot.children) {
                    try {
                        val upload = teacherSnapshot.getValue(Img::class.java)
                        if (upload != null) {
                            upload.key = teacherSnapshot.key
                            namaList.add(upload)
                        } else {
                            Log.e("HomeAct", "Failed to convert snapshot to Img")
                        }
                    } catch (e: DatabaseException) {
                        Log.e("HomeAct", "Error converting snapshot to Img: ${e.message}")
                    }
                }
                adrdAdapter.notifyDataSetChanged()
                binding.prgsbar.visibility = View.GONE
            }
        })

    }
}