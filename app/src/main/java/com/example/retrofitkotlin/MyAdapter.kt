package com.example.retrofitkotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Model


class MyAdapter(val results :List<Model>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rec_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("Rest response", ""+results[position])
        return holder.bind(results[position])

    }

    override fun getItemCount(): Int {
        return results.size
    }

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private val result:TextView = itemView.findViewById(R.id.result)

        fun bind(results: Model) {
            result.text = "Response: "+ (results.response?.userName )
        }
    }
}