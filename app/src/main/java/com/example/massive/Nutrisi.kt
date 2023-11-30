package com.example.massive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.massive.Information.BayamActivity
import com.example.massive.Information.BrokoliActivity
import com.example.massive.Information.DagingMerahActivity
import com.example.massive.Information.DaunSingkongActivity
import com.example.massive.Information.HatiActivity
import com.example.massive.Information.KacangMerahActivity
import com.example.massive.Information.KangkungActivity
import com.example.massive.Information.Tahuctivity
import com.example.massive.Information.TempeActivity
import com.example.massive.Information.UnggasActivity
import com.example.massive.databinding.FragmentNutrisiBinding

class Nutrisi : Fragment(R.layout.fragment_nutrisi) {
    private var _binding: FragmentNutrisiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutrisiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBottomNavigation()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        replaceFragment(Saran())

        binding.topNavBar.setItemSelected(R.id.tv_saran)
    }

    private fun setUpBottomNavigation() {
        binding.topNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.tv_saran -> replaceFragment(Saran())
                R.id.tv_hindari -> replaceFragment(Hindari())
                else -> {
                }
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_nutrisi, fragment)
        fragmentTransaction.commit()
    }


}

