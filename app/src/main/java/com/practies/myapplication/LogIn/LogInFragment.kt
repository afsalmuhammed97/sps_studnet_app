package com.practies.myapplication.LogIn

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.MainActivity
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentLoginBinding

class LogInFragment : Fragment() {

    private var _binding:FragmentLoginBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logInBt.setOnClickListener{
            val intent=Intent(context,MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        binding.signUpBt.setOnClickListener{
                 findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }

    }


}