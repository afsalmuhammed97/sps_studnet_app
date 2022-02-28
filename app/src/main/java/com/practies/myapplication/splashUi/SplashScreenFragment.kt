package com.practies.myapplication.splashUi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.MainActivity
import com.practies.myapplication.R



@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      Handler().postDelayed({
          //if boarding is finished
//          if (onBoardingCheck()){
//              val intent=Intent(context,MainActivity::class.java)
//              startActivity(intent)
//               requireActivity().finish()
//          }else{
//              findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)
//          }
          findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment2)


      },1000)


        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }


    private fun onBoardingCheck():Boolean{

        val sharedPref=requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        return  sharedPref.getBoolean("Finished",false)
    }
}
