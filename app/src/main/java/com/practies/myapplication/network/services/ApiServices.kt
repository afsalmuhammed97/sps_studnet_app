package com.practies.myapplication.network.services

import com.practies.myapplication.model.*
import com.practies.myapplication.network.helper.Constants.ADD_DOMAIN
import com.practies.myapplication.network.helper.Constants.ADD_STUDENT
import com.practies.myapplication.network.helper.Constants.DELETE_DOMAIN
import com.practies.myapplication.network.helper.Constants.GET_ALL_BATCH
import com.practies.myapplication.network.helper.Constants.GET_ALL_DOMAINS
import com.practies.myapplication.network.helper.Constants.GET_STUDENTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @POST("/signup")
   suspend fun studentSignUp(@Body signUpData: SignUpData):Response<ResponseMessage>

      //domain management
     @GET(GET_ALL_DOMAINS)
     suspend fun getAllDomains():Response<Domains >

    @POST(ADD_DOMAIN)
    suspend fun addNewDomain()

    @POST(DELETE_DOMAIN)
    suspend fun deleteDomain(@Body DomainName:String):Response<ResponseMessage >


    //student management
   @GET(GET_ALL_BATCH)
   suspend fun getAllBatches():Response<BatchData>

   @GET(GET_STUDENTS)
   suspend fun getAllStudents():Response<StudentData>

    @POST(ADD_STUDENT)
    suspend fun addStudent( @Body newStudent: NewStudent):ResponseMessage


    //student management




}