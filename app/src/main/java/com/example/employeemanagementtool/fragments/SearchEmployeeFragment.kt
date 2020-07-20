package com.example.employeemanagementtool.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.RecyclerViewAdapter
import com.example.employeemanagementtool.databinding.SearchEmployeeFragmentBinding
import com.example.employeemanagementtool.viewmodels.SearchEmployeeViewModel

class SearchEmployeeFragment : Fragment() {

   private val searchEmployeeViewModel by viewModels<SearchEmployeeViewModel>()
    private lateinit var employeeAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:SearchEmployeeFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.search_employee_fragment, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = searchEmployeeViewModel


        binding.searchButton.setOnClickListener {
            val firstName = binding.employeeFirstName.text.toString()
            val lastName = binding.employeeLastName.text.toString()

            if (firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
                Toast.makeText(context, "No records found", Toast.LENGTH_LONG).show()
            } else {
                searchEmployeeViewModel.getEmployeeByFirstAndLastName(firstName, lastName)
            }

            binding.searchRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                employeeAdapter = RecyclerViewAdapter()
                adapter = employeeAdapter
            }

            searchEmployeeViewModel.searchedResult.observe(viewLifecycleOwner, Observer {
                employeeAdapter.submitList(it)
            })

        }
        return binding.root
    }

}