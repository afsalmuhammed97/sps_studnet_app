package com.practies.myapplication.counsilor.counselorUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.counsilor.adapters.StudentAdapter
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
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_reviewer_list, container, false)
        _binding= FragmentReviewerListBinding.inflate(inflater,container,false)

         setView()
      return  binding.root
    }

    private fun setView(){
        val reviewers= listOf("Reviewer1","Reviewer2","Reviewer3","Reviewer4","Reviewer5","Reviewer6","Reviewer7","Reviewer8","Reviewer9")
           reviewerAdapter= StudentAdapter(reviewers,this)
        binding.reviewerRv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=reviewerAdapter
        }


    }

    override fun onItemClick(position: Int) {
      //  Toast.makeText(context,"${position}clicked",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_reviewerListFragment_to_reviewerPageFragment)
    }

}