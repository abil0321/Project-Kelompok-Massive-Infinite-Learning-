package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.appcompat.app.AppCompatDelegate
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
import com.example.massive.databinding.FragmentHindariBinding
import com.example.massive.databinding.FragmentNutrisiBinding
import com.example.massive.databinding.FragmentSaranBinding

class Hindari : Fragment(R.layout.fragment_hindari) {
    private var _binding: FragmentHindariBinding? = null
    private val binding get () = _binding !!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHindariBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.img11.setOnClickListener{
            val intent = Intent(activity, BayamActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img12.setOnClickListener{
            val intent = Intent(activity, KangkungActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img13.setOnClickListener{
            val intent = Intent(activity, DaunSingkongActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img14.setOnClickListener{
            val intent = Intent(activity, BrokoliActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img15.setOnClickListener{
            val intent = Intent(activity, Tahuctivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img16.setOnClickListener{
            val intent = Intent(activity, TempeActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img17.setOnClickListener{
            val intent = Intent(activity, KacangMerahActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img18.setOnClickListener{
            val intent = Intent(activity, HatiActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img19.setOnClickListener{
            val intent = Intent(activity, DagingMerahActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img20.setOnClickListener{
            val intent = Intent(activity, UnggasActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}