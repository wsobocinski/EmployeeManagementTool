package com.example.employeemanagementtool.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.employeemanagementtool.database.EmployeeDatabase
import com.example.employeemanagementtool.database.EmployeeDatabaseDao
import com.example.employeemanagementtool.database.models.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmployeeRepository private constructor(application: Application) {
    private val employeeDao: EmployeeDatabaseDao
    private val allEmployees: LiveData<List<Employee>>

    init {
        val employeeDatabase = EmployeeDatabase.getInstance(application)
        employeeDao = employeeDatabase.employeeDatabaseDao
        allEmployees = employeeDao.getAllEmployees()

    }

    suspend fun addEmployee(employee: Employee) {
        withContext(Dispatchers.IO) {
            employeeDao.addEmployee(employee)
        }
    }

    suspend fun editEmployee(employee: Employee) {
        withContext(Dispatchers.IO) {
            employeeDao.editEmployee(employee)
        }
    }

    suspend fun getEmployeeById(id: Int): Employee? {
        return withContext(Dispatchers.IO) {
            employeeDao.getEmployeeById(id)
        }
    }

    suspend fun getEmployeeByFirstAndLastName(firstName: String, lastName: String): List<Employee>? {
        return withContext(Dispatchers.IO) {
            employeeDao.getEmployeeByFirstAndLastName(firstName, lastName)
        }
    }

    fun getAllEmployees() : LiveData<List<Employee>>{
            return allEmployees
    }

    suspend fun removeEmployeeById(id: Int) {
        withContext(Dispatchers.IO) {
            employeeDao.removeEmployeeById(id)
        }
    }

    suspend fun removeEmployeeByFirstAndLastName(firstName: String, lastName: String) {
        withContext(Dispatchers.IO) {
            employeeDao.removeEmployeeByFirsAndLastName(firstName, lastName)
        }
    }

    suspend fun removeEmployee(employee: Employee) {
        withContext(Dispatchers.IO) {
            employeeDao.removeEmployee(employee)
        }
    }

    suspend fun removeAllEmployees() {
        withContext(Dispatchers.IO) {
            employeeDao.removeAllEmployees()
        }
    }

    companion object {
        private var INSTANCE: EmployeeRepository? = null

        fun getInstance(application: Application): EmployeeRepository {
            var instance = INSTANCE
            if (instance == null) {
                instance = EmployeeRepository(application)
                INSTANCE = instance
            }
            return instance
        }
    }
}