package com.practies.myapplication.network.services

import com.practies.myapplication.SignUpData
import com.practies.myapplication.SignUpResponse
import com.practies.myapplication.model.BatchData
import com.practies.myapplication.network.helper.Constants.GET_ALL_BATCH
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @POST("/signup")
   suspend fun studentSignUp(@Body signUpData: SignUpData):Response<SignUpResponse>




   //teacher
   @GET(GET_ALL_BATCH)
   suspend fun getAllBatches():Response<BatchData>

}