package com.example.employeemanagementtool.database.models

import androidx.room.*

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    val employeeId: Int = 0,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val age: Int,
    val gender: Gender,
    val addresses: List<String>
)

