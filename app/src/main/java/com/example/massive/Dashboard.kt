package com.example.massive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.massive.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpTabBar()
    }
    private fun setUpTabBar() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it){
                R.id.home -> replaceFragment(Home())
                R.id.nutrisi -> replaceFragment(Nutrisi())
                R.id.reminder -> replaceFragment(Reminder())
                R.id.profile -> replaceFragment(Setting())
                else ->{
                }
            }
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}