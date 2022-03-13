package com.practies.myapplication.academic_adviser.adviser_ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentAllStudentBinding
import com.practies.myapplication.model.NewStudent
import com.practies.myapplication.model.ResponseMessage
import com.practies.myapplication.viewModels.AdviserViewModel


class AllStudentsFragment : Fragment() {

  private var _binding: FragmentAllStudentBinding?=null
    private  val binding get() = _binding!!
  private val adviserViewModel:AdviserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding=FragmentAllStudentBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner=viewLifecycleOwner

            viewModel=adviserViewModel

            allStudentsFragment= this@AllStudentsFragment
        }

        binding.floatingActionButton.setOnClickListener{
//            var dialog=DialogShowFragment()
//            dialog.show(parentFragmentManager,"add_student_sheet")
             addStudentWindow()

        }



    }






    fun addStudentWindow() {
        val alertDialog = AlertDialog.Builder(context)
             alertDialog.setCancelable(true)

        val inflater = LayoutInflater.from(context)
        val mView: View = inflater.inflate(R.layout.add_student_sheet, null)

        val  name_= mView.findViewById<EditText>(R.id.student_name)
        val  email_= mView.findViewById<EditText>(R.id.student_email)
        val  batch_= mView.findViewById<Spinner>(R.id.batch_spinner3)
        val  cancel=mView.findViewById<Button>(R.id.cancel_bt)
        val   ok_button=mView.findViewById<Button>(R.id.ok_bt)

        alertDialog.create()
        alertDialog.setView(mView)

        ok_button.setOnClickListener{
               val student=generateNewStudent(name_,email_)

               val message=addNewStudent(student)

               Toast.makeText(context,message?.errors,Toast.LENGTH_SHORT).show()
           }


        alertDialog.setNegativeButton("cancel") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.cancel()

        }


        alertDialog.setPositiveButton("save") { _: DialogInterface, i: Int ->

          //generated newStudent object

        }


            alertDialog.show()
   }


    // to generate new student objet
    private fun generateNewStudent( name:EditText,email:EditText)=
         NewStudent( "BCK11", email.text.toString(),name.text.toString())




    // api call from the viewModel
    private fun addNewStudent(newStudent: NewStudent)=

        adviserViewModel.addNewStudent(newStudent)







}


