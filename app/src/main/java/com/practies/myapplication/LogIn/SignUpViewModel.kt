package com.practies.myapplication.LogIn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.myapplication.network.repositories.LoginRepository
import com.practies.myapplication.model.SignUpData
import com.practies.myapplication.model.ResponseMessage
import kotlinx.coroutines.launch
import retrofit2.Response

class SignUpViewModel(private val repository: LoginRepository):ViewModel() {
      val responseResult=MutableLiveData<Response<ResponseMessage>>()

    fun studentSignUp( signUpData: SignUpData){

        viewModelScope.launch {
         //   val response:Response<ResponseMessage> = repository.studentSignUp(signUpData)
            //  Log.i("MSG","test")

//            responseResult.value=response
//            Log.i("TEST1", response.message())
//            Log.i("respons1", response.body().toString())
        }



//        try {
//            viewModelScope.launch {
//                val response:Response<ResponseMessage> = repository.studentSignUp(signUpData)
//
//              responseResult.value=response.body()
//            }
//        }catch (e:Exception){
//            Log.i("Exception","Request failed")
//
//        }
    }
}