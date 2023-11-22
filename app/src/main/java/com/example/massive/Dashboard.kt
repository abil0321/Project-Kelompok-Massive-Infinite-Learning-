package com.example.massive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.massive.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {
    private lateinit var textUserName: TextView
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpTabBar()
        showCustomAlertDialog()

    }

    private fun setUpTabBar() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it){
                R.id.home -> replaceFragment(Home())
                R.id.nutrisi -> replaceFragment(Nutrisi())
                R.id.reminder -> replaceFragment(Reminder())
                R.id.profile -> replaceFragment(Profile())
                else ->{
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }

    private fun showCustomAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.popup_ayominumobat, null)
        val customPopupText = dialogView.findViewById<TextView>(R.id.popup_reminder)
        customPopupText.text = "Ayo Minum Obat"

        builder.setView(dialogView)
            .setPositiveButton("Sudah") { dialog, which ->
                dialog.dismiss()
            }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}
