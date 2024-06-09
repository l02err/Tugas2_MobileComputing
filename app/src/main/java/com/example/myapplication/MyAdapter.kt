package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var mContext: HomeAct, var namaList:List<Img> ):
    RecyclerView.Adapter<MyAdapter.ListViewHolder>() {

    inner class ListViewHolder(var v:View): RecyclerView.ViewHolder(v){
        val imgT = v.findViewById<ImageView>(R.id.imageView)
        val nameT = v.findViewById<TextView>(R.id.tVTitle)
        val veT = v.findViewById<TextView>(R.id.tVDes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder{
        var infalter = LayoutInflater.from(parent.context)
        var v = infalter.inflate(R.layout.item_data,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount():Int = namaList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = namaList[position]
        holder.nameT.text = newList.name
        holder.veT.text = newList.verson
        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener{

            val name = newList.name
            val vers = newList.verson
            val desc = newList.description
            val imgUri = newList.imageUrl

            val mIntent = Intent(mContext,DetailAct::class.java )
            mIntent.putExtra("NAMET", name)
            mIntent.putExtra("VET",vers)
            mIntent.putExtra("DESCRIT",desc)
            mIntent.putExtra("IMGURI",imgUri)
            mContext.startActivity(mIntent)
        }
    }
}