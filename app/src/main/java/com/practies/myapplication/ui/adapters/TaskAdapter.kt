package com.practies.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.TaskItemBinding

class TaskAdapter(val taskList:ArrayList<String>,
               private   val listener: OnItemClickListener
):RecyclerView.Adapter<TaskAdapter.TaskHolder>() {




  inner  class TaskHolder( val  binding: TaskItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener {

        init {
            binding.item1.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position=absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION){

                listener.onItemClick( position)
            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {


        return TaskHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
                holder.binding.weekText.text=taskList[position]
    }

    override fun getItemCount()=taskList.size

    interface OnItemClickListener{
        fun onItemClick( position: Int)
    }

}