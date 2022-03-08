package com.practies.myapplication.counsilor.counselorUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.counsilor.adapters.DomainAdapter
import com.practies.myapplication.counsilor.counselorUi.home.TeacherViewModel
import com.practies.myapplication.databinding.FragmentCousilorHomeBinding
import com.practies.myapplication.interfaces.OnItemClickListeners
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class counselorHomeFragment : Fragment(),OnItemClickListeners{
private  var _binding: FragmentCousilorHomeBinding?=null
    private val binding get() = _binding!!
private lateinit var batchAdapter:DomainAdapter

         private val viewModel by viewModels<TeacherViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_cousilor_home, container, false)
  _binding= FragmentCousilorHomeBinding.inflate(inflater,container,false)
      setView()


       // viewModel.batchLiveData

       Toast.makeText(context,viewModel.batchLiveData.toString(),Toast.LENGTH_SHORT).show()

        return  binding.root

    }


    private fun setView(){
        val batches= listOf("BCK1","BCK2","BCK3","BCK4","BCK6","BCK7","BCK8","BCK9","BCK10")
          batchAdapter= DomainAdapter(batches,this)
        binding.counselorHomeRv.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter=batchAdapter
        }

    }

    override fun onItemClick(position: Int) {
      //  Toast.makeText(context,"${position} clicked", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_cousilorHomeFragment_to_domainFragment)
    }


}