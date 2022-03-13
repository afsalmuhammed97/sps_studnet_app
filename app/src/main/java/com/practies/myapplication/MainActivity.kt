package com.practies.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.practies.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
 //   private lateinit var listener: NavController.OnDestinationChangedListener
    companion object{
     var isTeacher :Boolean=false
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       isTeacher=intent.getBooleanExtra("teacher",false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     Toast.makeText( applicationContext,if (isTeacher) "Teacher" else "student", Toast.LENGTH_SHORT).show()
       setSupportActionBar(binding.appBarMain.toolbar)
           // ActionBar.DISPLAY_HOME_AS_UP
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

     val studentScreens=setOf(
         R.id.profileFragment2,
         R.id.tasksFragment,
         R.id.manifestFragment,
         R.id.notificationsFragment,
         R.id.homeFragment)

     val counsilorScreens= setOf(
         R.id.cousilorHomeFragment,
         R.id.domainFragment,
         R.id.reviewerListFragment,
         R.id.schedulesFragment)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView


        val navController = findNavController(R.id.nav_host_fragment_content_main)

       appBarConfiguration = AppBarConfiguration( if(isTeacher) counsilorScreens else studentScreens
           ,drawerLayout)

         navController.setGraph( if (isTeacher) R.navigation.adviser_nav else  R.navigation.mobile_navigation  )
     binding.navView.inflateMenu(if (isTeacher) R.menu.adviser_drawer else R.menu.activity_main_drawer)      //

      setupActionBarWithNavController(navController , appBarConfiguration)

        navView.setupWithNavController(navController)

        drawerAnimation()
    }

    private fun selectNavigation(student:Boolean,drawerLayout:DrawerLayout){

        val studentScreens=setOf(
            R.id.profileFragment2,
            R.id.tasksFragment,
            R.id.manifestFragment,
            R.id.notificationsFragment,
            R.id.homeFragment)

    // val counsilorScreens= setOf(R.id.domainFragment,R.id.reviewerListFragment,R.id.schedulesFragment)

      //  appBarConfiguration = AppBarConfiguration(   counsilorScreens ,drawerLayout)

       // binding.navView.inflateMenu(R.menu.counsilor_drawer)      //R.menu.activity_main_drawer) //diffine with if cace

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun drawerAnimation(){
        val scaleControl=6f
        binding.apply {

            drawerLayout.drawerElevation=0f
            drawerLayout.setScrimColor(Color.TRANSPARENT)
            drawerLayout.addDrawerListener(object :DrawerLayout.DrawerListener{

                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    val slideX=drawerView.width*slideOffset
                   constraint.translationX=slideX


                     constraint.scaleY = 1-(slideOffset/scaleControl)

                }

                override fun onDrawerOpened(drawerView: View) {}

                override fun onDrawerClosed(drawerView: View) {}

                override fun onDrawerStateChanged(newState: Int) {}

            })








        }

    }
}