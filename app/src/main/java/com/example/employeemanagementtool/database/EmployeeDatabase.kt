package com.example.employeemanagementtool.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.employeemanagementtool.database.models.Employee

@TypeConverters(Converters::class)
@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract val employeeDatabaseDao: EmployeeDatabaseDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDatabase::class.java,
                        "employee_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}