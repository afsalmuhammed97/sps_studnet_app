package com.practies.myapplication.splashUi.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.practies.myapplication.R

class SecondFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_second, container, false)

        val nextButton=view.findViewById<Button>(R.id.button2)
        val viewPager=activity?.findViewById<ViewPager2>(R.id.viewPager1)

        nextButton.setOnClickListener{
            viewPager?.currentItem=2
            // 1 is the index of second page
        }
        return view
    }


}