package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Halaman Home Aplikasi

class HomeAct : AppCompatActivity() {
    private lateinit var adrdRecyclerView: RecyclerView
    private lateinit var jenis: Array<String>
    private lateinit var versi: Array<String>
    private lateinit var gambar: Array<Int>
    private lateinit var detal: Array<String>
    private lateinit var listAdrd: ArrayList<ItemData>


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
            "Android Alpha",
            "Android Beta",
            "Android Cupcake",
            "Android Donut",
            "Android Eclair",
            "Android Froyo",
            "Android Gingerbread",
            "Android Honeycomb",
            "Android Ice Cream Sandwich",
            "Android Jelly Bean",
            "Android Kit Kat",
            "Android Lolipop",
            "Android Marshmallow",
            "Android Nougat",
            "Android Oreo",
            "Android Pie",
            "Android Ten"
        )

        versi = arrayOf(
            "Versi 1.0",
            "Versi 1.1",
            "Versi 1.5",
            "Versi 1.6",
            "Versi 2.0",
            "Versi 2.2",
            "Versi 2.3",
            "Versi 3.0",
            "Versi 4.0",
            "Versi 4.1",
            "Versi 4.4",
            "Versi 5.0",
            "Versi 6.0",
            "Versi 7.0",
            "Versi 8.0",
            "Versi 9.0",
            "Versi 10"
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
    }

    private fun getDataUser() {
        for (i in gambar.indices) {
            val dataAndrd = ItemData(gambar[i], jenis[i], versi[i])
            listAdrd.add(dataAndrd)
        }

        val adapter = MyAdapter(listAdrd)
        adrdRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                intent = Intent(this@HomeAct, DetailAct::class.java)
                intent.putExtra("idgambar", listAdrd[position].gambar)
                intent.putExtra("idjenis", listAdrd[position].jenis)
                intent.putExtra("idversi", listAdrd[position].versi)
                intent.putExtra("iddetal", detal[position])

                startActivity(intent)
            }
        })
    }
}