package com.practies.myapplication.counsilor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.StudentViewBinding

import com.practies.myapplication.interfaces.OnItemClickListeners

 class StudentAdapter(val students:List<String>,private val listener:OnItemClickListeners):RecyclerView.Adapter<StudentAdapter.ItemViewHolder>() {
   inner class ItemViewHolder(val binding:StudentViewBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener {

       init {
           binding.cardItem.setOnClickListener(this)
       }

        override fun onClick(v: View?) {
            val position=absoluteAdapterPosition
            if (position !=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ItemViewHolder {
      return  ItemViewHolder(StudentViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: StudentAdapter.ItemViewHolder, position: Int) {
      holder.binding.studentName.text=students[position]
    }
    override fun getItemCount()=students.size
}