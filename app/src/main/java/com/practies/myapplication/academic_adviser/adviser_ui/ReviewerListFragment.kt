package com.practies.myapplication.academic_adviser.adviser_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.academic_adviser.adapters.StudentAdapter
import com.practies.myapplication.databinding.FragmentReviewerListBinding
import com.practies.myapplication.interfaces.OnItemClickListeners


class ReviewerListFragment : Fragment(),OnItemClickListeners {

  private  var _binding: FragmentReviewerListBinding?=null
    private val binding get() = _binding!!
    private lateinit var reviewerAdapter:StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentReviewerListBinding.inflate(inflater,container,false)

         setView()
      return  binding.root
    }

    private fun setView(){

          reviewerAdapter= StudentAdapter(this)

             binding.reviewerRv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=reviewerAdapter
        }


    }

    override fun onItemClick(position: Int) {

        findNavController().navigate(R.id.action_reviewerListFragment_to_reviewerPageFragment)
    }

}