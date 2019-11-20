package com.ds.githubsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.result_item.view.*

class RecyclerAdapter(val issueTitles: ArrayList<String>, val idLabels: ArrayList<String>, val nodeLabels: ArrayList<String>, val urlLabels: ArrayList<String>, val nameLabels: ArrayList<String>, val colorLabels: ArrayList<String>, val defaultLabels: ArrayList<String>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount() = issueTitles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titles.text = issueTitles[position]
        holder.id.text = "ID: " + idLabels[position]
        holder.node_id.text = "Node ID: " + nodeLabels[position]
        holder.url.text = "URL: " + urlLabels[position]
        holder.name.text = "Name " + nameLabels[position]
        holder.color.text = "Color: " + colorLabels[position]
        holder._default.text = "Default: " + defaultLabels[position]
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
    val titles = v.titles
    val id = v._id
    val node_id = v.node_id
    val url = v.url
    val name = v.name
    val color = v.color
    val _default = v._default
}