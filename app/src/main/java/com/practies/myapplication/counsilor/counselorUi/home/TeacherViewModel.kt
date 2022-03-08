package com.practies.myapplication.counsilor.counselorUi.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.myapplication.model.Batch
import com.practies.myapplication.network.repositories.TeacherRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class TeacherViewModel @Inject constructor ( val repository: TeacherRepository) :ViewModel(){

     val batchLiveData=MutableLiveData<List<Batch>>()

  //  fun getAllBatches()=batchLiveData

    init {
      getAllBatches()

    }

    fun getAllBatches(){
        try {
            viewModelScope.launch {
                val result=repository.getAllBatches()

                val batches=result.body()?.batches

                batchLiveData.value=batches!!
                Log.i("DATA",batches.toString())
            }
        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }

}