package com.example.employeemanagementtool.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.employeemanagementtool.*
import com.example.employeemanagementtool.databinding.UpdateEmployeeFragmentBinding
import com.example.employeemanagementtool.viewmodels.UpdateEmployeeViewModel

class UpdateEmployeeFragment : Fragment() {

    private val updateEmployeeViewModel: UpdateEmployeeViewModel by viewModels<UpdateEmployeeViewModel>()
    lateinit var binding: UpdateEmployeeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.update_employee_fragment, container, false)

        binding.lifecycleOwner = this

        setUtilContext(context)
        binding.updateEmployeeButton.setOnClickListener {
            val firstName = binding.firstName
            val lastName = binding.lastName
            val age = binding.age
            val gender = binding.gender
            val addresses = binding.addresses
            if (validateFirstName(binding.firstName) && validateLastName(binding.lastName) &&
                validateAge(binding.age) && validateGender(binding.gender) && validateAddresses(binding.addresses)
            ) {
                updateEmployeeViewModel.addEmployee(
                    getEmployeeFromInputs(firstName, lastName, age, gender, addresses)
                )

                showToast("Employee added.")
                clearDataInInputs()
            }
        }
        return binding.root
    }

    private fun clearDataInInputs() {
        binding.firstName.text?.clear()
        binding.lastName.text?.clear()
        binding.age.text?.clear()
        binding.gender.text?.clear()
        binding.addresses.text?.clear()
    }

}