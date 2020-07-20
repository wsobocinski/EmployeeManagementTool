package com.example.employeemanagementtool

import android.content.Context
import android.widget.Toast
import androidx.databinding.adapters.Converters
import com.example.employeemanagementtool.database.models.Employee
import com.example.employeemanagementtool.database.models.Gender
import com.google.android.material.textfield.TextInputEditText
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


lateinit var utilsContext: Context

fun setUtilContext(context: Context?) {
    utilsContext = context!!
}

fun validateFirstName(inputEditText: TextInputEditText): Boolean {
    val firstName = inputEditText.text.toString()
    if (firstName.trim().isEmpty()) {
        showToast("Incorrect first name field.")
        return false
    }
    return true
}

fun validateLastName(inputEditText: TextInputEditText): Boolean {
    val lastName = inputEditText.text.toString()
    if (lastName.trim().isEmpty()) {
        showToast("Incorrect last name field.")
        return false
    }
    return true
}

fun validateAge(inputEditText: TextInputEditText): Boolean {
    val age = inputEditText.text.toString().toInt()
    if (age < 16 || age > 100) {
        showToast("Incorrect age field.")
        return false
    }
    return true
}

fun validateGender(inputEditText: TextInputEditText): Boolean {
    val gender = inputEditText.text.toString()
    val genders = listOf("NONE", "M", "F")
    if (!genders.contains(gender)) {
        showToast("Incorrect gender field.")
        return false
    }
    return true
}

fun validateAddresses(inputEditText: TextInputEditText): Boolean {
    val addresses = inputEditText.text.toString()
    if (addresses.isEmpty()) {
        showToast( "Incorrect addresses field.")
        return false
    }
    return true
}

fun getEmployeeFromInputs(firstNameIT: TextInputEditText, lastNameIT: TextInputEditText, ageIT: TextInputEditText,
genderIt: TextInputEditText, addressesIT: TextInputEditText): Employee {
    val firstName = firstNameIT.text.toString()
    val lastName = lastNameIT.text.toString()
    val age = ageIT.text.toString().toInt()
    val gender = toGender(genderIt.text.toString())
    val addresses = listOf(addressesIT.text.toString())

    return Employee(0, firstName, lastName, age, gender!!, addresses!!)
}

fun toGender(string: String?): Gender? {
    when (string) {
        "M" -> return Gender.M
        "F" -> return Gender.F
    }
    return Gender.NONE
}

fun showToast(message: String) {
    Toast.makeText(utilsContext, message, Toast.LENGTH_LONG).show()
}