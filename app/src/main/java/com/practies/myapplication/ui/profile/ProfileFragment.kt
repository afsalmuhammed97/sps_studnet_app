package com.practies.myapplication.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      //  return inflater.inflate(R.layout.fragment_profile, container, false)

   binding= FragmentProfileBinding.inflate(inflater,container,false)

        binding.editButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment2_to_profileCompletionFragment)
        }

    return binding.root}
}