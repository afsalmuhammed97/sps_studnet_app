package com.practies.myapplication.counsilor.counselorUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.counsilor.adapters.StudentAdapter
import com.practies.myapplication.databinding.FragmentStuendentListBinding
import com.practies.myapplication.interfaces.OnItemClickListeners


class StudentListFragment : Fragment(),OnItemClickListeners {
   private  var _binding: FragmentStuendentListBinding?=null
    private val  binding get() = _binding!!
private lateinit var studentAdapter: StudentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
   _binding= FragmentStuendentListBinding.inflate(inflater,container,false)

            setView()
  return binding.root
    }

    private fun setView(){
        val students= listOf("student1","student2","student3","student4","student5","student6","student7","student8","student9")
           studentAdapter= StudentAdapter(students,this)

        binding.studentRv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=studentAdapter
        }


    }

    override fun onItemClick(position: Int) {
          findNavController().navigate(R.id.action_stuendentListFragment_to_studentViewFragment)
    }

}