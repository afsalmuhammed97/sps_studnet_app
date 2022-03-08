package com.practies.myapplication.splashUi.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.practies.myapplication.MainActivity
import com.practies.myapplication.R

class FifthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_fifth, container, false)

        val nextButton=view.findViewById<Button>(R.id.button5)

        nextButton.setOnClickListener{
            onBoardingFinished()
           val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
           // Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show()

//            findNavController().navigate(R.id.action_walkeThroughFragment1_to_homeFragment2)



        }
        return view
    }

    private fun onBoardingFinished(){
        val sharedPref=requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor=sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
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