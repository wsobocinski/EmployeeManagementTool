package com.example.employeemanagementtool.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.employeemanagementtool.viewmodels.AddEmployeeViewModel
import com.example.employeemanagementtool.R

class AddEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() =
            AddEmployeeFragment()
    }

    private lateinit var viewModel: AddEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}