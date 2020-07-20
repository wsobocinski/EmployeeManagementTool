package com.example.employeemanagementtool.database

import com.example.employeemanagementtool.database.models.Gender
import org.junit.Test

class ConvertersTest {
    private val converter = Converters()
    @Test
    fun fromGender_genderNONE_returnStringNONE() {
        assert(converter.fromGender(Gender.NONE) =="NONE")
    }

    @Test
    fun fromGender_genderMALE_returnStringMALE() {
        assert(converter.fromGender(Gender.M) =="M")
    }

    @Test
    fun fromGender_genderFEMALE_returnStringFEMALE() {
        assert(converter.fromGender(Gender.F) =="F")
    }

    @Test
    fun toGender_error_returnGenderNONE() {
        assert(converter.toGender("error") == Gender.NONE)
    }

    @Test
    fun toGender_null_returnGenderNONE() {
        assert(converter.toGender(null) == Gender.NONE)
    }

    @Test
    fun toGender_stringM_returnGenderM() {
        assert(converter.toGender("M") == Gender.M)
    }
    @Test
    fun toGender_stringF_returnGenderF() {
        assert(converter.toGender("F") == Gender.F)
    }

    @Test
    fun fromAddresses_null_returnEmptyString() {
        assert(converter.fromAddresses(null) == "")
    }

    @Test
    fun fromAddresses_emptyList_returnEmptyString() {
        assert(converter.fromAddresses(emptyList()) == "")
    }
}