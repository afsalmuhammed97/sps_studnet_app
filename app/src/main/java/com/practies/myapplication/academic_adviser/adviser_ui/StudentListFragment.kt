package com.practies.myapplication.academic_adviser.adviser_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.academic_adviser.adapters.StudentAdapter
import com.practies.myapplication.databinding.FragmentStuendentListBinding
import com.practies.myapplication.interfaces.OnItemClickListeners
import com.practies.myapplication.viewModels.AdviserViewModel


class StudentListFragment : Fragment(),OnItemClickListeners {
    private  var _binding: FragmentStuendentListBinding?=null
    private val  binding get() = _binding!!

    private lateinit var studentAdapter: StudentAdapter
    private val viewModel:AdviserViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
   _binding= FragmentStuendentListBinding.inflate(inflater,container,false)

            setView()
  return binding.root
    }

    private fun setView(){

        viewModel.studentsLiveData.observe(viewLifecycleOwner){
            studentAdapter.differ.submitList(it)
        }
           studentAdapter= StudentAdapter(this)



        binding.studentRv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=studentAdapter
        }


    }

    override fun onItemClick(position: Int) {
          findNavController().navigate(R.id.action_stuendentListFragment_to_studentViewFragment)
    }

}