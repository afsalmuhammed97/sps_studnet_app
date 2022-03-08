package com.practies.myapplication.network.services

import okhttp3.ResponseBody

sealed class Resource<out T> {

    data class Success<out T>(val value:T):Resource<T>()

     data class Failure(
         val isNetWorkError:Boolean,
         val errorCode:Int?,
         val errorBody:ResponseBody?
     )
}