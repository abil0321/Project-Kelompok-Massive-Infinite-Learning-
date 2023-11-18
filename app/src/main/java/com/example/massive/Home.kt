package com.example.massive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentHomeBinding

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPerbaharui.setOnClickListener {
            val anemiaStatus = AnemiaStatus()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply{
                replace(R.id.frame_layout, anemiaStatus, AnemiaStatus::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}