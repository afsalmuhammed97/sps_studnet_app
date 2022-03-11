package com.practies.myapplication.network.repositories

import com.practies.myapplication.network.services.ApiServices
import javax.inject.Inject

class TeacherRepository @Inject constructor(private val apiServices: ApiServices) {

    suspend fun getAllBatches()=apiServices.getAllBatches()

    suspend fun getAllDomains()=apiServices.getAllDomains()

}