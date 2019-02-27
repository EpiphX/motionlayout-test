package com.example.christopherburuchian.motionlayout

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DemoAdapter(private val listener: Listener, private val data: List<Demo>) :
    RecyclerView.Adapter<DemoAdapter.ViewHolder>() {

    interface Listener {
        fun onDemoSelected(demo: Demo)
    }

    data class Demo(val title: String, val layout: Int = 0, val activity: Class<*> = DemoActivity::class.java)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.demo_item, parent, false)
        return ViewHolder(viewHolder)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val demo = data[position]
            titleView.text = demo.title
            itemView.setOnClickListener {
                adapterPosition
                listener.onDemoSelected(demo)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.title)
    }
}