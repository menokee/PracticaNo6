package com.edu.uabc.appm.practicano6

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.edu.uabc.appm.practicano6.modelo.User2

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var superheros: MutableList<User2> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(superheros : MutableList<User2>, context: Context){
        this.superheros = superheros
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = superheros.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_json_list, parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vuserId = view.findViewById(R.id.tvUserId) as TextView
        val vid = view.findViewById(R.id.tvId) as TextView
        val vtitle = view.findViewById(R.id.tvTitle) as TextView
        val vcompleted = view.findViewById(R.id.tvCompleted) as TextView

        fun bind(superhero:User2, context: Context){
            vuserId.text = superhero.userId.toString()
            vid.text = superhero.id.toString()
            vtitle.text = superhero.title
            vcompleted.text = superhero.completed.toString()
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.id.toString(), Toast.LENGTH_SHORT).show() })

        }

    }


}