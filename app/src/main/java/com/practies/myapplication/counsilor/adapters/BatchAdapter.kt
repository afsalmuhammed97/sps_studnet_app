package com.practies.myapplication.counsilor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.DomainViewItemBinding
import com.practies.myapplication.interfaces.OnItemClickListeners
import com.practies.myapplication.model.Batch

//val domains:List<String>,
class BatchAdapter  (
                     private val listener:OnItemClickListeners
):RecyclerView.Adapter<BatchAdapter.ItemHolder>() {




    private val diffCallBack=object :DiffUtil.ItemCallback<Batch>(){
        override fun areItemsTheSame(oldItem: Batch, newItem: Batch): Boolean {
            return  oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Batch, newItem: Batch): Boolean {

            return  oldItem._id==newItem._id
        }
    }

    val differ=AsyncListDiffer(this,diffCallBack)



    inner  class ItemHolder(val binding: DomainViewItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       return  ItemHolder(DomainViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       holder.binding.itemText.text=differ.currentList[position].BatchName
    }

    override fun getItemCount()= differ.currentList.size


}