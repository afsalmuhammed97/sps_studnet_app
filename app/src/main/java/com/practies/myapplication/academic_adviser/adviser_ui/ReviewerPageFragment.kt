package com.practies.myapplication.academic_adviser.adviser_ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentReviewerPageBinding


class ReviewerPageFragment : Fragment() {
   private var _binding:FragmentReviewerPageBinding?=null

   private  val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_reviewer_page, container, false)

        _binding= FragmentReviewerPageBinding.inflate(inflater,container,false)

        binding.scheduleBt.setOnClickListener{
            scheduleDialog()
        }
     return   binding.root
    }


    private fun scheduleDialog() {
        val alertDialog = AlertDialog.Builder(context)
        val customView =
            LayoutInflater.from(context).inflate(R.layout.costom_dilog, binding.root, false)


        alertDialog.setView(customView)
        alertDialog.setNegativeButton("cancel") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()

        }

        alertDialog.setPositiveButton("schedule") { _: DialogInterface, i: Int -> }
        alertDialog.create()
        alertDialog.show()
    }


    }