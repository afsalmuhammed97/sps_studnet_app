package com.practies.myapplication.viewModels

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practies.myapplication.R
import com.practies.myapplication.databinding.ActivityMainBinding.inflate
import com.practies.myapplication.databinding.FragmentAllStudentBinding
import com.practies.myapplication.model.*
import com.practies.myapplication.network.repositories.TeacherRepository
import com.practies.myapplication.network.services.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class AdviserViewModel @Inject constructor (private val repository: TeacherRepository) :ViewModel(){


   private  val _batchLiveData=MutableLiveData<List<Batch>>()
    val batchLiveData:LiveData<List<Batch>>  get() = _batchLiveData

   private   val _domainsLiveData=MutableLiveData<List<Domain>>()
    val domainsLiveData:LiveData<List<Domain>>  get()= _domainsLiveData


    private val _studentsLiveData=MutableLiveData<List<Student>>()
      val  studentsLiveData:LiveData<List<Student>> get() = _studentsLiveData

   //  fun getAllBatches()=batchLiveData

    init {
        getAllBatches()
        getAllDomains()
        getAllStudents()
    }

    private fun getAllBatches(){
        try {
            viewModelScope.launch {
                val result=repository.getAllBatches()

                _batchLiveData.value=result.body()?.batches

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

                _domainsLiveData.value=result.body()?.domains
            }
        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }
    }

    private fun getAllStudents(){
        try {
            viewModelScope.launch {

                val result=repository.getAllStudents()

                _studentsLiveData.value=result.body()?.students
            }
        }catch (e:Exception){
            Log.i("Exception",e.toString())
        }

    }


    fun addNewStudent(newStudent: NewStudent): ResponseMessage? {
        var result: ResponseMessage?=null
            try {
                viewModelScope.launch {

                   result= repository.addStudent(newStudent)

                }
            }catch (e:Exception){
                Log.i("Exception",e.toString())
            }
             return result
    }


    fun showDialog(context: Context){
         val okButton:Button
        val cancel:Button
        val email:EditText
        val name:EditText
        val batch_spinner:Spinner
        val dialog= Dialog(context)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.add_student_sheet)
        dialog.create()
          dialog.show()

            dialog.apply {
               okButton=findViewById(R.id.ok_bt)
               cancel=findViewById(R.id.cancel_bt)
                email= findViewById(R.id.email)
               name =findViewById(R.id.student_name)
               batch_spinner=findViewById(R.id.batch_spinner3)
            }
              cancel.setOnClickListener{
                  dialog.dismiss()
              }


    }



}