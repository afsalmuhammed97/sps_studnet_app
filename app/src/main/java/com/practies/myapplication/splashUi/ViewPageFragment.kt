package com.practies.myapplication.splashUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.practies.myapplication.R
import com.practies.myapplication.splashUi.screens.*


class ViewPageFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_walke_through1,container,false)
        val viewpager=view.findViewById<ViewPager2>(R.id.viewPager1)
        val fragmentList= arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThiredFragment(),
            FourthFragment(),
            FifthFragment()
        )
            val adapterP=viewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
              viewpager.adapter=adapterP
        return  view
    }


}