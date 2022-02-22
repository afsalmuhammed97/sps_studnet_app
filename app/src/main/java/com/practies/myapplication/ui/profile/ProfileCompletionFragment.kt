package com.practies.myapplication.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentProfileCompletionBinding

class ProfileCompletionFragment : Fragment() {
private lateinit var binding:FragmentProfileCompletionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_profile_completion, container, false)
        binding= FragmentProfileCompletionBinding.inflate(inflater,container,false)

 val domains=resources.getStringArray(R.array.domains)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.drop_down_item,domains)
        binding.autoCompleteTextView.setAdapter(arrayAdapter )
    return    binding.root
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

}