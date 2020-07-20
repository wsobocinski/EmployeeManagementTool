package com.example.employeemanagementtool.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeemanagementtool.database.models.Employee
import com.example.employeemanagementtool.repository.EmployeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchEmployeeViewModel(application: Application) : AndroidViewModel(application) {
    private val viewModelApplication = application
    private val employeeRepository = EmployeeRepository.getInstance(application)
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _searchedResult =  MutableLiveData<List<Employee>>()
    val searchedResult: LiveData<List<Employee>>
        get() = _searchedResult

    fun getEmployeeById(id: Int) {
        uiScope.launch {
            val searchResult = employeeRepository.getEmployeeById(id)
            if (searchResult == null) {
                displayNoEmployeesFoundToast()
            } else {
                _searchedResult.value = listOf(searchResult)
            }
        }
    }

    private fun displayNoEmployeesFoundToast() {
        Toast.makeText(viewModelApplication, "0 employees found", Toast.LENGTH_LONG).show()
    }

    fun getEmployeeByFirstAndLastName(firstName: String, lastName: String) {
        uiScope.launch {
            val searchResult = employeeRepository.getEmployeeByFirstAndLastName(firstName, lastName)
            if (searchResult == null || searchResult.isEmpty()) {
                displayNoEmployeesFoundToast()
            } else {
                _searchedResult.value = searchResult
            }
        }
    }
}