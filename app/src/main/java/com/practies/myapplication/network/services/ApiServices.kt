package com.practies.myapplication.network.services

import com.practies.myapplication.SignUpData
import com.practies.myapplication.SignUpResponse
import com.practies.myapplication.model.BatchData
import com.practies.myapplication.model.Domain
import com.practies.myapplication.model.Domains
import com.practies.myapplication.network.helper.Constants.ADD_STUDENT
import com.practies.myapplication.network.helper.Constants.GET_ALL_BATCH
import com.practies.myapplication.network.helper.Constants.GET_ALL_DOMAINS
import com.practies.myapplication.network.helper.Constants.GET_STUDENTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @POST("/signup")
   suspend fun studentSignUp(@Body signUpData: SignUpData):Response<SignUpResponse>

      //domain management
   @GET(GET_ALL_DOMAINS)
   suspend fun getAllDomains():Response<Domains >


   //teacher management
   @GET(GET_ALL_BATCH)
   suspend fun getAllBatches():Response<BatchData>

   @GET(GET_STUDENTS)
   suspend fun getAllStudents()

    @POST(ADD_STUDENT)
    suspend fun addStudent()

}