package com.practies.myapplication.counsilor.counselorUi.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.myapplication.model.Batch
import com.practies.myapplication.model.Domain
import com.practies.myapplication.network.repositories.TeacherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class TeacherViewModel @Inject constructor (private val repository: TeacherRepository) :ViewModel(){


     val batchLiveData=MutableLiveData<List<Batch>>()
     val domainsLiveData=MutableLiveData<List<Domain>>()


  //  fun getAllBatches()=batchLiveData

    init {
        getAllBatches()
        getAllDomains()
    }

    private fun getAllBatches(){
        try {
            viewModelScope.launch {
                val result=repository.getAllBatches()

                batchLiveData.value=result.body()?.batches

                Log.i("DATA",result.body()?.batches.toString())
            }
        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }

    private fun getAllDomains(){
        try {
            viewModelScope.launch {

                val result=repository.getAllDomains()

                domainsLiveData.value=result.body()?.domains
            }
        }catch (e:Exception){

        }
    }

}