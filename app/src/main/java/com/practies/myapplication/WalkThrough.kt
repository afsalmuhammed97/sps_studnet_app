    package com.practies.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class WalkThrough : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

          supportActionBar?.hide()
        //val bt=findViewById<Button>(R.id.get_start_bt)
      supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

      //  val navController=naveHostFragment.navController
//        bt.setOnClickListener{
//            val intent=Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            this.finish()
//        }
    }
}