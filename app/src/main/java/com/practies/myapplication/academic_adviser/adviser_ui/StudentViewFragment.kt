package com.practies.myapplication.academic_adviser.adviser_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.practies.myapplication.databinding.FragmentStudentViewBinding
import com.practies.myapplication.splashUi.ViewPagerAdapter
import com.practies.myapplication.ui.manifest.ManifestFragment
import com.practies.myapplication.ui.profile.ProfileFragment
import com.practies.myapplication.ui.tasks.TasksFragment


class StudentViewFragment : Fragment() {
private  var _binding:FragmentStudentViewBinding?=null
    private val binding get() = _binding!!
private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

   _binding= FragmentStudentViewBinding.inflate(inflater,container,false)

        setViewPager()

  return  binding.root
    }

    private fun setViewPager(){
        val fragmentList= arrayListOf<Fragment>(
            TasksFragment(),
            ManifestFragment(),
            ProfileFragment()
             )

        viewPagerAdapter= ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        binding.viewPagerStudent.adapter=viewPagerAdapter

        TabLayoutMediator(binding.tabLayout,binding.viewPagerStudent){ tab,position ->
            when(position){
               0 -> {tab.text="Tasks"}
                1 ->{tab.text="Manifest"}
                2->{tab.text="Profile"}  }

        }.attach()


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