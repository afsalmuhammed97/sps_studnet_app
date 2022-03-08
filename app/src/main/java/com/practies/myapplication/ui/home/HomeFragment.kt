package com.practies.myapplication.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.practies.myapplication.R

import com.practies.myapplication.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private var _binding:HomeFragmentBinding?=null                              //FragmentHome1Binding?=null
    private val  binding get() = _binding!!

//    companion object {
//        fun newInstance() = HomeFragment()
//    }

  //  private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= HomeFragmentBinding.inflate(inflater,container,false)

        (requireActivity() as AppCompatActivity).supportActionBar?.show()
          return  binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

  ///  https://intensecoder.com/piechart-tutorial-using-mpandroidchart-in-kotlin/
    //documantation


}