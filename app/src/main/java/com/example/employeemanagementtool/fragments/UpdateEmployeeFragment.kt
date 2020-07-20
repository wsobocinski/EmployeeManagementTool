package com.example.employeemanagementtool.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.viewmodels.UpdateEmployeeViewModel

class UpdateEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() =
            UpdateEmployeeFragment()
    }

    private lateinit var viewModel: UpdateEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.update_employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpdateEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}