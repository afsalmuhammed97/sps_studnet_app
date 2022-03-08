package com.practies.myapplication.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.practies.myapplication.R

import com.practies.myapplication.databinding.FragmentProfileFormBinding

class ProfileCompletionFragment : Fragment() {

    private lateinit var binding:FragmentProfileFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding= FragmentProfileFormBinding.inflate(inflater,container,false)
 val domains=resources.getStringArray(R.array.domains)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.drop_down_item,domains)

        val domainList= listOf("Domain", "Web development","appDevelopment","Cyber Security","Node","Python","Java","Flutter",)

        val domainAdapter= ArrayAdapter<String>(requireContext(),R.layout.support_simple_spinner_dropdown_item,domainList)
            //ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,domainList)
        binding.spinner1.adapter=domainAdapter
        binding.spinner1.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{



            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
              Toast.makeText(view!!.context,"position${adapterView?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    return    binding.root
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