package com.practies.myapplication.academic_adviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.practies.myapplication.databinding.DomainViewItemBinding
import com.practies.myapplication.interfaces.OnItemClickListeners
import com.practies.myapplication.model.Domain

//val domains:List<String>,
class DomainAdapter  (
                     private val listener:OnItemClickListeners
):RecyclerView.Adapter<DomainAdapter.ItemHolder>() {




    private val diffCallBack=object :DiffUtil.ItemCallback<Domain>(){
        override fun areItemsTheSame(oldItem: Domain, newItem: Domain): Boolean {
            return  oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Domain, newItem: Domain): Boolean {

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
       holder.binding.itemText.text=differ.currentList[position].DomainName
    }

    override fun getItemCount()= differ.currentList.size


}