package com.practies.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.practies.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var listener: NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)         //(binding.appBarMain.toolbar)
      //  binding.toolbar.navigationIcon?.setTint(Color.WHITE)



//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.   navController.graph
        appBarConfiguration = AppBarConfiguration(navController.graph    ,drawerLayout)
             //   setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)

//        setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        drawerAnimation()
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