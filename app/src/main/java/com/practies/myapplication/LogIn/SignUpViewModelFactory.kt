package com.practies.myapplication.LogIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practies.myapplication.network.repositories.LoginRepository

class SignUpViewModelFactory(private val repository: LoginRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(repository) as T
    }
}