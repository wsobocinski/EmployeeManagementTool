package com.example.employeemanagementtool.database

import androidx.room.TypeConverter
import com.example.employeemanagementtool.database.models.Gender
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Converters {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val type = Types.newParameterizedType(List::class.java, String::class.java)
    private val moshiAdapter =  moshi.adapter<List<String>>(type)

    @TypeConverter
    fun fromGender(gender: Gender): String {
        return gender.toString()
    }

    @TypeConverter
    fun toGender(string: String?): Gender? {
        when (string) {
            "M" -> return Gender.M
            "F" -> return Gender.F
        }
        return Gender.NONE
    }

    @TypeConverter
    fun fromAddresses(addresses: List<String>?): String {
        if (addresses == null || addresses.isEmpty()) {
            return ""
        }
        return moshiAdapter.toJson(addresses)
    }

    @TypeConverter
    fun toAddresses(addresses: String?): List<String>? {
        if (addresses == null || addresses.isEmpty()) {
            return emptyList()
        }
       return moshiAdapter.fromJson(addresses)
    }
}