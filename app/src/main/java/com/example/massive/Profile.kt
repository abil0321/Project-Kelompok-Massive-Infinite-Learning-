package com.example.massive

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.massive.databinding.FragmentProfileBinding

class Profile : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(activity, EditProfile::class.java)
            startActivity(intent)
        }
        binding.tentangKami.setOnClickListener {
            val intent = Intent(activity, TentangKami::class.java)
            startActivity(intent)
        }
        binding.layananKonsumen.setOnClickListener {
            val intent = Intent(activity, LayananKonsumen::class.java)
            startActivity(intent)
        }
        binding.logout.setOnClickListener {
            val intent = Intent(activity, Login::class.java)
            startActivity(intent)
        }
    }
}
