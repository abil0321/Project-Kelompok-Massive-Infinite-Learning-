package com.example.massive

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentHomeBinding
import com.example.massive.infoAnemia.InfoAnemiaActivity

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val text: TextView = binding.reciveUsername
        val value = arguments?.getString("name")
        text.text = "Halo, $value"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPerbaharui.setOnClickListener {
            val intent = Intent(activity, AnemiaStatus::class.java)
            startActivity(intent)
        }

        binding.tvLanjut.setOnClickListener {
            val intent = Intent(requireActivity(), InfoAnemiaActivity::class.java)
            startActivity(intent)
        }
    }
}