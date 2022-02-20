package com.practies.myapplication.ui.manifest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.practies.myapplication.R
import com.practies.myapplication.databinding.FragmentManifestBinding
import com.practies.myapplication.model.Week
import com.practies.myapplication.model.Workout
import com.practies.myapplication.ui.adapters.MainWeekAdapter

class ManifestFragment : Fragment() {
  private lateinit var binding: FragmentManifestBinding
  private lateinit var mainAdapter:MainWeekAdapter
 //   val workout1= arrayListOf<Workout>()            // emptyList<Workout>()               // emptyArray<Workout>()
    val weekList= arrayListOf<Week>()
     val workoutList= arrayListOf<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
      //  return inflater.inflate(R.layout.fragment_manifest, container, false)
    binding= FragmentManifestBinding.inflate(inflater,container,false)

        workoutList.add("Technical")
        workoutList.add("Personal")
        workoutList.add("Miscellaneous")

        val week1=Week(weekCount = "week1",workoutList)
        val week2=Week(weekCount = "week2",workoutList)
        val week3=Week(weekCount = "week3",workoutList)
        val week4=Week(weekCount = "week4",workoutList)








          weekList.add(week1)
        weekList.add(week2)
        weekList.add(week3)
        weekList.add(week4)










         //workout1[0].workoutType="Technical"
//        workout1[0].workoutType="Technical"
//        workout1[1].workoutType="Personal"
//        workout1[3].workoutType="Miscellaneous"



//        weekList[0].weekCount="week1"
//        weekList[0].workoutList=workout1              // =workout1
//        weekList[1].weekCount="week2"
//        weekList[1].workoutList =workout1
//        weekList[2].weekCount="week2"
//        weekList[2].workoutList =workout1
//        weekList[3].weekCount="week2"
//        weekList[3].workoutList =workout1
//        weekList[4].weekCount="week2"
//        weekList[4].workoutList =workout1
//        weekList[5].weekCount="week2"
//        weekList[5].workoutList =workout1


        return  binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("Test",weekList[0].weekCount)
        Log.i("Test2",weekList[0].workoutList.toString())





        setUpManifestView( weekList)

    }

    private fun setUpManifestView( list: List<Week>) {
        mainAdapter=MainWeekAdapter(context!!,list)
        binding.manifestRv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=mainAdapter
        }

    }




}