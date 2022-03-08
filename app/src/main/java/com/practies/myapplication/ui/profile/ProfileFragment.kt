package com.practies.myapplication.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.MainActivity
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
private lateinit var binding: FragmentProfileBinding
    val teacher= MainActivity.isTeacher
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


   binding= FragmentProfileBinding.inflate(inflater,container,false)

        if (teacher){
            binding.editButton.isVisible=false
        }

        binding.editButton.setOnClickListener {

            if ( ! teacher) {
                findNavController().navigate(R.id.action_profileFragment2_to_profileCompletionFragment)

            }
        }

    return binding.root}
}