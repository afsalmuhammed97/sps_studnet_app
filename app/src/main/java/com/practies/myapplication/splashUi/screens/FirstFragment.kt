package com.practies.myapplication.splashUi.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.practies.myapplication.R

class FirstFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view= inflater.inflate(R.layout.fragment_first, container, false)
         val viewPager=activity?.findViewById<ViewPager2>(R.id.viewPager1)
         val nextButton=view.findViewById<Button>(R.id.button1)

        nextButton.setOnClickListener{
            viewPager?.currentItem=1
            // 1 is the index of second page
        }
        return view
    }

}