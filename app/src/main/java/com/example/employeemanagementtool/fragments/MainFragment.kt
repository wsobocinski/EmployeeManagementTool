package com.example.employeemanagementtool.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.RecyclerViewAdapter
import com.example.employeemanagementtool.databinding.MainFragmentBinding
import com.example.employeemanagementtool.viewmodels.MainViewModel

class MainFragment : Fragment() {
    private val mainFragmentViewModel by viewModels<MainViewModel>()
    private lateinit var employeeAdapter: RecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: MainFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.main_fragment, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = mainFragmentViewModel
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            employeeAdapter = RecyclerViewAdapter()
            adapter = employeeAdapter
        }

        mainFragmentViewModel.getAllEmployees().observe(viewLifecycleOwner, Observer {
            employeeAdapter.submitList(it)
        })

        binding.addEmployeeButton.setOnClickListener {
            this.findNavController().navigate(MainFragmentDirections
                .actionMainFragmentToAddEmployeeFragment()
            )
        }
        binding.removeEmployeeButton.setOnClickListener {
            this.findNavController().navigate(MainFragmentDirections
                .actionMainFragmentToRemoveEmployeeFragment()
            )
        }
        binding.updateEmployeeButton.setOnClickListener {
            this.findNavController().navigate(MainFragmentDirections
                .actionMainFragmentToUpdateEmployeeFragment()
            )
        }
        binding.searchEmployeeButton.setOnClickListener {
            this.findNavController().navigate(MainFragmentDirections
                .actionMainFragmentToSearchEmployeeFragment()
            )
        }


        return binding.root
    }
}