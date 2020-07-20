package com.example.employeemanagementtool.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private val mainFragmentViewModel by viewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: MainFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.main_fragment, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = mainFragmentViewModel


        return binding.root
    }
}