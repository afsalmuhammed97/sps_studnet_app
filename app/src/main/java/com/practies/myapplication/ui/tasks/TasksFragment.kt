package com.practies.myapplication.ui.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.ui.adapters.TaskAdapter
import com.practies.myapplication.databinding.FragmentTasksBinding

class TasksFragment : Fragment(), TaskAdapter.OnItemClickListener {
    lateinit var binding: FragmentTasksBinding
    lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentTasksBinding.inflate(inflater,container,false)
           setView()

        return  binding.root
    }

    fun setView(){

        val weeks= arrayListOf<String>()
        weeks.add("week 1")
        weeks.add("week 2")
        weeks.add("week 3")
        weeks.add("week 4")
        weeks.add("week 5")
        weeks.add("week 6")
        weeks.add("week 7")
        weeks.add("week 7")
        weeks.add("week 8")
        weeks.add("week 9")
        weeks.add("week 10")
        weeks.add("week 11")

        taskAdapter= TaskAdapter(weeks,this)
          binding.taskRv.apply {
              layoutManager= GridLayoutManager(context,2)
              adapter=taskAdapter
          }
    }

    override fun onItemClick(position: Int) {
       Toast.makeText(context,"${position} clicked",Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_tasksFragment_to_taskBotomSeetFragment)
    }


}