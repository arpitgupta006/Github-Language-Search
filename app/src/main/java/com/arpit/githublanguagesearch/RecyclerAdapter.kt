package com.arpit.githublanguagesearch

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(private val fullName: List<String> ,private val ownerLogin: List<String> , private val description: List<String>,
                       ):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val itemFullName: TextView = itemView.findViewById(R.id.tvFullName)
        val itemOwnerLogin: TextView = itemView.findViewById(R.id.tvOwnerLogin)
        val itemDescription: TextView = itemView.findViewById(R.id.tvDescription)

//        init {
//            itemView.setOnClickListener {
//                val position :Int = adapterPosition
//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = Uri.parse(links[position])
//                ContextCompat.startActivity(itemView.context, intent, null)
//            }
//        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent ,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fullName.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemFullName.text=fullName[position]
        holder.itemOwnerLogin.text=ownerLogin[position]
        holder.itemDescription.text=description[position]


    }
}