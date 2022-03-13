package com.practies.myapplication.academic_adviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.StudentViewBinding

import com.practies.myapplication.interfaces.OnItemClickListeners
import com.practies.myapplication.model.Student

class StudentAdapter(

     private val listener:OnItemClickListeners

 ):RecyclerView.Adapter<StudentAdapter.ItemViewHolder>() {

     private val diffCallBack=object :DiffUtil.ItemCallback<Student>() {
         override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
             return  oldItem==newItem
         }

         override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return  oldItem._id==newItem._id
         }

     }
    val differ=AsyncListDiffer(this,diffCallBack)


   inner class ItemViewHolder(val binding:StudentViewBinding
   ):RecyclerView.ViewHolder(binding.root),View.OnClickListener {


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

          holder.binding.apply {
                       studentName.text=differ.currentList[position].Name
                       batch.text=differ.currentList[position].Batch
          }
    }
    override fun getItemCount()=differ.currentList.size
}