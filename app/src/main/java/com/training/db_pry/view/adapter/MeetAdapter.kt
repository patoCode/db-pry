package com.training.db_pry.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.training.db_pry.R
import com.training.db_pry.model.data.entity.Metting

class MeetAdapter internal constructor(meets: MutableList<Metting>):
    RecyclerView.Adapter<MeetAdapter.ViewHolder>() {

    private var meets:MutableList<Metting> = meets

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        // agregar las demas variables
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meet,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meets[position]
        holder.title.text = item.title
        // holder.create.text = SimpleDateFormat("dd/mm/yyyy").format(item.create)
    }

    override fun getItemCount(): Int {
        return meets.size
    }

}