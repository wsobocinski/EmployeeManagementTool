package com.example.employeemanagementtool.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.employeemanagementtool.database.models.Employee
import com.example.employeemanagementtool.repository.EmployeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddEmployeeViewModel(application: Application) : AndroidViewModel(application) {
    private val employeeRepository = EmployeeRepository.getInstance(application)
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun addEmployee(employee: Employee) {
        uiScope.launch {
            employeeRepository.addEmployee(employee)
        }
    }

}