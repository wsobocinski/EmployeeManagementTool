package com.example.employeemanagementtool.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.employeemanagementtool.R
import com.example.employeemanagementtool.viewmodels.RemoveEmployeeViewModel

class RemoveEmployeeFragment : Fragment() {

    companion object {
        fun newInstance() =
            RemoveEmployeeFragment()
    }

    private lateinit var viewModel: RemoveEmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.remove_employee_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RemoveEmployeeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}