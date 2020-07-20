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

    @Query("DELETE FROM employees WHERE first_name = :firstName AND last_name = :lastName")
    fun removeEmployeeByFirsAndLastName(firstName: String, lastName: String)

    @Update
    fun editEmployee(employee: Employee)

    @Query("SELECT * from employees WHERE employee_id = :employeeId")
    fun getEmployeeById(employeeId: Int): Employee?

    @Query("SELECT * from employees WHERE first_name = :firstName AND last_name = :lastName")
    fun getEmployeeByFirstAndLastName(firstName: String, lastName: String):  List<Employee>?

    @Query("SELECT * from employees ORDER BY employee_id DESC")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Query("DELETE FROM employees")
    fun removeAllEmployees()
}