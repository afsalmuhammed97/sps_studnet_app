package com.practies.myapplication.ui.bottomSheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentTaskBotomSeetBinding


class TaskBotomSeetFragment : BottomSheetDialogFragment( ) {
  private   var _binding: FragmentTaskBotomSeetBinding?=null
  private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// use switch case for sharing and navigating to taskViewFragment

    }



    override fun getTheme(): Int {
        return com.practies.myapplication.R.style.BottomSheetDialog_Rounded
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding=FragmentTaskBotomSeetBinding.inflate(inflater,container,false)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personalCard.setOnClickListener{

            findNavController().navigate(R.id.action_taskBotomSeetFragment_to_taskViewFragment)
        }


    }

}