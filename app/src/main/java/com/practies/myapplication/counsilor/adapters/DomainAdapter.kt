package com.practies.myapplication.counsilor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.DomainViewItemBinding
import com.practies.myapplication.interfaces.OnItemClickListeners


class DomainAdapter(val domains:List<String>,
                     private val listener:OnItemClickListeners
):RecyclerView.Adapter<DomainAdapter.ItemHolder>() {



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
       holder.binding.itemText.text=domains[position]
    }

    override fun getItemCount()=domains.size


}