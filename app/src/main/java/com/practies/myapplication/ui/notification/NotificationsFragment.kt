package com.practies.myapplication.ui.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {
    private  var _binding: FragmentNotificationsBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentNotificationsBinding.inflate(inflater,container,false)
        return  binding.root
    }


}