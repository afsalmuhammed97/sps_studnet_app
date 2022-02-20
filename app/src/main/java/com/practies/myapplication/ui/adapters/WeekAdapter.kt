package com.practies.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.WeeksCardItemBinding
import com.practies.myapplication.model.Workout

class WeekAdapter(val workoutList:ArrayList<String>):RecyclerView.Adapter<WeekAdapter.ViewHolder>() {


    class ViewHolder(val binding: WeeksCardItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
          return  ViewHolder(WeeksCardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.tittle.text=workoutList[position]           //workoutList[position]
    }

    override fun getItemCount()=workoutList.size

}