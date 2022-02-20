package com.practies.myapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.MainCardItemBinding
import com.practies.myapplication.model.Week
import com.practies.myapplication.model.Workout

class MainWeekAdapter(private val context: Context, val weekList:List<Week>,):RecyclerView.Adapter<MainWeekAdapter.MainViewHolder>() {



    class MainViewHolder(val binding:MainCardItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(MainCardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
      holder.binding.weekCount.text=weekList[position].weekCount

      val workoutList=weekList[position].workoutList

        val weekList= arrayListOf<String>()
        weekList.addAll(workoutList)
        setTasksRecyclerView(context,holder.binding.recyclerView,weekList )
    }

    override fun getItemCount()=weekList.size

    private fun setTasksRecyclerView(  context: Context,recyclerView: RecyclerView,workoutList:ArrayList<String>){
       val adapter=WeekAdapter(workoutList)
        recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
       recyclerView.adapter=adapter
    }
}