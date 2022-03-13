package com.practies.myapplication.academic_adviser.adviser_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.academic_adviser.adapters.BatchAdapter
import com.practies.myapplication.viewModels.AdviserViewModel
import com.practies.myapplication.databinding.FragmentCousilorHomeBinding
import com.practies.myapplication.interfaces.OnItemClickListeners
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdviserHomeFragment : Fragment(),OnItemClickListeners{
private  var _binding: FragmentCousilorHomeBinding?=null

    private val binding get() = _binding!!
    private lateinit var batchAdapter:BatchAdapter


         private val viewModel by  activityViewModels<AdviserViewModel>()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

  _binding= FragmentCousilorHomeBinding.inflate(inflater,container,false)

      setView()



        return  binding.root

    }


    private fun setView(){
      //  val batches= listOf("BCK1","BCK2","BCK3","BCK4","BCK6","BCK7","BCK8","BCK9","BCK10")

         batchAdapter= BatchAdapter(this)

            viewModel.batchLiveData.observe(viewLifecycleOwner){
            batchAdapter.differ.submitList(it)

        }

        binding.counselorHomeRv.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter=batchAdapter

        }

    }

    override fun onItemClick(position: Int) {
        findNavController().navigate(R.id.action_cousilorHomeFragment_to_domainFragment)
    }


}