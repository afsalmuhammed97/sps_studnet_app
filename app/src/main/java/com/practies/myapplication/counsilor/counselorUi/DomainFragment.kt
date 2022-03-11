package com.practies.myapplication.counsilor.counselorUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.counsilor.adapters.DomainAdapter
import com.practies.myapplication.counsilor.counselorUi.home.TeacherViewModel
import com.practies.myapplication.databinding.FragmentDomainBinding
import com.practies.myapplication.interfaces.OnItemClickListeners

class DomainFragment : Fragment(),OnItemClickListeners {


    private  var _binding: FragmentDomainBinding ?=null
    private val binding get() = _binding!!
    private lateinit var domainAdapter:DomainAdapter
  //  private val viewModel by viewModels<TeacherViewModel> ()
    private val viewModel:TeacherViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

//private val sharedViewModel: OrderViewModel by activityViewModels()
   _binding= FragmentDomainBinding.inflate(inflater,container,false)

      setUpView()
       return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       // val viewModel = ViewModelProvider(requireActivity()).get(TeacherViewModel::class.java)
    }

    private fun setUpView(){
        val domains= listOf("kotlin Android","flutter","Node","Python","CyberSecurity","Devops","BlockChain")
        domainAdapter= DomainAdapter(this)

        viewModel.domainsLiveData.observe(viewLifecycleOwner){

            domainAdapter.differ.submitList(it)
        }
        binding.counselorDomainRv.apply {
            layoutManager=GridLayoutManager(context,2)
            adapter=domainAdapter
        }
    }

    override fun onItemClick(position: Int) {
       // Toast.makeText(context,"${position} clicked", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_domainFragment_to_stuendentListFragment)
    }


}