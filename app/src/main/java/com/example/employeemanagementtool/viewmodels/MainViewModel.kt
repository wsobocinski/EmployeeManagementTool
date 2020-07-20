package com.example.employeemanagementtool.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.employeemanagementtool.database.models.Employee
import com.example.employeemanagementtool.database.models.Gender
import com.example.employeemanagementtool.repository.EmployeeRepository
import kotlinx.coroutines.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeRepository: EmployeeRepository = EmployeeRepository.getInstance(application)
    private var allEmployees: LiveData<List<Employee>>
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        allEmployees = employeeRepository.getAllEmployees()
    }


    fun getAllEmployees() : LiveData<List<Employee>>{
        return allEmployees
    }

     fun addToDatabase() {
         uiScope.launch {
             employeeRepository.addEmployee(Employee(0, "Jack", "Stephanovic", 21, Gender.M, listOf("Wiejska3")))
             employeeRepository.addEmployee(Employee(0, "Jacko", "Anovic", 12, Gender.M, listOf("Ska133")))
             employeeRepository.addEmployee(Employee(0, "Jacklin", "Stephanovic", 19, Gender.F, listOf("Wiejska3")))

         }

    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}