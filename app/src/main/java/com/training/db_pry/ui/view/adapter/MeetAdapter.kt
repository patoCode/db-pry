package com.training.db_pry.ui.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.training.db_pry.R
import com.training.db_pry.R.color.app_green_light
import com.training.db_pry.data.entity.Meeting
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.SimpleDateFormat

class MeetAdapter internal constructor(meets: MutableList<Meeting>):
    RecyclerView.Adapter<MeetAdapter.ViewHolder>() {

    private var meets:MutableList<Meeting> = meets
    private lateinit var clickListener : ClickListener

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var descripcion = itemView.findViewById<TextView>(R.id.tvDesc)
        var status = itemView.findViewById<ImageView>(R.id.ivStatus)
        var color = itemView.findViewById<CardView>(R.id.cvContainer)
        var date = itemView.findViewById<TextView>(R.id.tvDate)

        var edit = itemView.findViewById<ImageView>(R.id.btnEdit)
    }

    fun setClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meet,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meets[position]
        holder.title.text = item.title
        holder.descripcion.text = item.desc
        holder.date.text = SimpleDateFormat("dd/mm/yyyy").format(item.create)
        holder.color.setCardBackgroundColor(Color.parseColor(item.color))
        if(item.status.toUpperCase() == "OK"){
            holder.status.setImageResource(R.drawable.ic_color)
            //holder.color.setCardBackgroundColor(ContextCompat.getColor(,R.color.app_green_light))
        }else{
            holder.status.setImageResource(R.drawable.ic_status)
        }
        holder.edit.setOnClickListener {
            clickListener.onClickMeet(holder.itemView, item)
        }
    }

    override fun getItemCount(): Int {
        return meets.size
    }

}