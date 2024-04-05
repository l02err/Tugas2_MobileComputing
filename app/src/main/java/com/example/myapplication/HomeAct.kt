package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Halaman Home Aplikasi

class HomeAct : AppCompatActivity() {
   private lateinit var adrdRecyclerView : RecyclerView
   private lateinit var adrdAdapter: MyAdapter
   private lateinit var jenis : Array<String>
   private lateinit var versi : Array<String>
   private lateinit var gambar : Array<Int>
   private lateinit var detal : Array<String>
   private lateinit var listAdrd : ArrayList<ItemData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gambar = arrayOf(
            R.drawable.alpha,
            R.drawable.beta,
            R.drawable.cck,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.foryo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecsandwich,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lolipop,
            R.drawable.marshmallow,
            R.drawable.nougat,
            R.drawable.oreo,
            R.drawable.pie,
            R.drawable.ten,
        )

        jenis = arrayOf(
            "Android Alpha","Android Beta","Android Cupcake", "Android Donut", "Android Eclair", "Android Froyo","Android Gingerbread", "Android Honeycomb", "Android Ice Cream Sandwich", "Android Jelly Bean", "Android Kit Kat", "Android Lolipop", "Android Marshmallow", "Android Nougat", "Android Oreo", "Android Pie", "Android Ten"
        )

        versi = arrayOf(
            "Versi 1.0", "Versi 1.1", "Versi 1.5", "Versi 1.6", "Versi 2.0","Versi 2.2", "Versi 2.3", "Versi 3.0", "Versi 4.0", "Versi 4.1", "Versi 4.4", "Versi 5.0", "Versi 6.0", "Versi 7.0", "Versi 8.0", "Versi 9.0", "Versi 10"
        )

        detal = arrayOf(
            getString(R.string.a),
            getString(R.string.b),
            getString(R.string.c),
            getString(R.string.d),
            getString(R.string.e),
            getString(R.string.f),
            getString(R.string.g),
            getString(R.string.h),
            getString(R.string.i),
            getString(R.string.j),
            getString(R.string.k),
            getString(R.string.l),
            getString(R.string.m),
            getString(R.string.n),
            getString(R.string.o),
            getString(R.string.p),
            getString(R.string.q),
        )

        adrdRecyclerView = findViewById(R.id.andrRV)
        adrdRecyclerView.layoutManager = LinearLayoutManager(this)
        adrdRecyclerView.setHasFixedSize(true)

        listAdrd = arrayListOf<ItemData>()
        getDataUser()

        adrdRecyclerView = findViewById(R.id.andrRV)
        listAdrd = ArrayList()

        listAdrd.add(ItemData(R.drawable.alpha, "Android Alpha", "Versi 1.0"))
        listAdrd.add(ItemData(R.drawable.beta, "Android Beta", "Versi 1.1"))
        listAdrd.add(ItemData(R.drawable.cck, "Android Cupcake", "Versi 1.5"))
        listAdrd.add(ItemData(R.drawable.donut, "Android Donut", "Versi 1.6"))
        listAdrd.add(ItemData(R.drawable.eclair, "Android Eclair", "Versi 2.0"))
        listAdrd.add(ItemData(R.drawable.foryo, "Android Froyo", "Versi 2.2"))
        listAdrd.add(ItemData(R.drawable.gingerbread, "Android Gingerbread", "Versi 2.3"))
        listAdrd.add(ItemData(R.drawable.honeycomb, "Android Honeycomb", "Versi 3.0"))
        listAdrd.add(ItemData(R.drawable.icecsandwich, "Android Ice Cream Sandwich", "Versi 4.0"))
        listAdrd.add(ItemData(R.drawable.jellybean, "Android Jelly Bean", "Versi 4.1"))
        listAdrd.add(ItemData(R.drawable.kitkat, "Android Kit Kat", "Versi 4.4"))
        listAdrd.add(ItemData(R.drawable.lolipop, "Android Lolipop", "Versi 5.0"))
        listAdrd.add(ItemData(R.drawable.marshmallow, "Android Marshmallow", "Versi 6.0"))
        listAdrd.add(ItemData(R.drawable.nougat, "Android Nougat", "Versi 7.0"))
        listAdrd.add(ItemData(R.drawable.oreo, "Android Oreo", "Versi 8.0"))
        listAdrd.add(ItemData(R.drawable.pie, "Android Pie", "Versi 9.0"))
        listAdrd.add(ItemData(R.drawable.ten, "Android Ten", "Versi 10"))

        adrdRecyclerView.layoutManager = LinearLayoutManager(this)
        adrdRecyclerView.setHasFixedSize(true)
        adrdAdapter = MyAdapter(listAdrd)
        adrdRecyclerView.adapter = adrdAdapter

    }

    private fun getDataUser() {
        for (i in gambar.indices){
            val dataAndrd = ItemData(gambar[i],jenis[i],versi[i])
            listAdrd.add(dataAndrd)
        }

        var adapter = MyAdapter(listAdrd)
        adrdRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int){
                intent = Intent(this@HomeAct, DetailAct :: class.java)
                intent.putExtra("idgambar", listAdrd[position].gambar)
                intent.putExtra("idjenis", listAdrd[position].jenis)
                intent.putExtra("idversi", listAdrd[position].versi)
                intent.putExtra("iddetal", detal[position])

                startActivity(intent)
            }
        })
    }
}