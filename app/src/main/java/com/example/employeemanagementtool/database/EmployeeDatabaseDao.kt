package com.example.employeemanagementtool.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.employeemanagementtool.database.models.Employee

@Dao
interface EmployeeDatabaseDao {
    @Insert
    fun addEmployee(employee: Employee)

    @Delete
    fun removeEmployee(employee: Employee)

    @Query("DELETE FROM employees WHERE employee_id= :employeeId")
    fun removeEmployeeById(employeeId: Int)

    @Update
    fun editEmployee(employee: Employee)

    @Query("SELECT * from employees WHERE employee_id = :employeeId")
    fun getEmployeeById(employeeId: Int): Employee?

    @Query("SELECT * from employees ORDER BY employee_id DESC")
    fun getAllEmployees(): LiveData<List<Employee>>
}