package com.practies.myapplication.network.repositories

import com.practies.myapplication.network.services.ApiServices

class TeacherRepository(private val apiServices: ApiServices) {

    suspend fun getAllBatches()=apiServices.getAllBatches()

}