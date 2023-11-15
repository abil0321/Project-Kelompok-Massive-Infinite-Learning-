package com.example.massive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentSettingBinding

class Setting : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
       //return inflater.inflate(R.layout.fragment_setting, container, false)
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logout.setOnClickListener {
            val setting = Setting()
            val mFragmentManager = parentFragmentManager
            mFragmentManager
                .beginTransaction().apply {
                    replace(R.id.login, setting, Login::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
        }
    }
}