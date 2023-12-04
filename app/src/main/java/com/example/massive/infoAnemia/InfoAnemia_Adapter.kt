package com.example.massive.infoAnemia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.massive.R

class InfoAnemia_Adapter(private val context: Context, private val superhero: List<InfoAnemia_Model>, val listener: (InfoAnemia_Model) -> Unit)
    : RecyclerView.Adapter<InfoAnemia_Adapter.InfoanemiaViewHolder>(){

    class InfoanemiaViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgInfoAnemia = view.findViewById<ImageView>(R.id.img_item_photo)
        val titleInfoAnemia = view.findViewById<TextView>(R.id.tv_item_name)
        fun bindView(superhero: InfoAnemia_Model, listener: (InfoAnemia_Model) -> Unit){
            imgInfoAnemia.setImageResource(superhero.imgInfoAnemia)
            titleInfoAnemia.text = superhero.titleInfoAnemia

            itemView.setOnClickListener {
                listener(superhero)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoanemiaViewHolder {
        return InfoanemiaViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_infoanemia, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InfoanemiaViewHolder, position: Int) {
        holder.bindView(superhero[position], listener)
    }

    override fun getItemCount(): Int = superhero.size

}