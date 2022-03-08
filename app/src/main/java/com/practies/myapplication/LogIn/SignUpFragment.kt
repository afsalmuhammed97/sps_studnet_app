package com.practies.myapplication.LogIn

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.R
import com.practies.myapplication.network.repositories.LoginRepository
import com.practies.myapplication.SignUpData
import com.practies.myapplication.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

private  var _binding: FragmentSignUpBinding?=null
    private val binding get() = _binding!!

    lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

     _binding= FragmentSignUpBinding.inflate(inflater,container,false)

     val repository =LoginRepository()

       val viewModelFactory=SignUpViewModelFactory(repository)
       viewModel=ViewModelProvider(this,viewModelFactory).get(SignUpViewModel::class.java)

     return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpBt2.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_walkeThroughFragment1)

        //   signUp()


        }

    }
    private fun signUp(){
        val name=binding.nameInput.text.toString()
        val email=binding.emailInput.text.toString()
        val password=binding.password.text.toString()


     val studentSignUp=   SignUpData(email,name,password)
        viewModel.studentSignUp(studentSignUp)
        viewModel.responseResult.observe( viewLifecycleOwner, Observer { response->


            if (response.isSuccessful){
                val data =response.body()
               // val result= viewModel.responseResult
                Log.i("Msg",viewModel.responseResult.toString())



              //  Toast.makeText(context,result.toString(),Toast.LENGTH_SHORT).show()

            }
        })







    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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