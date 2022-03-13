package com.practies.myapplication.network.repositories

import com.practies.myapplication.model.NewStudent
import com.practies.myapplication.network.services.ApiServices
import javax.inject.Inject

class TeacherRepository @Inject constructor(private val apiServices: ApiServices) {

    suspend fun getAllBatches()=apiServices.getAllBatches()

    suspend fun getAllDomains()=apiServices.getAllDomains()

    suspend fun getAllStudents()=apiServices.getAllStudents()

    suspend fun addStudent(newStudent: NewStudent)=apiServices.addStudent(newStudent)

}