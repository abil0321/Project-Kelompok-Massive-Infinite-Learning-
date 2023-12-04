package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
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
import com.example.massive.Information2.BerasmerahActivity
import com.example.massive.Information2.BijibijianActivity
import com.example.massive.Information2.GandumActivity
import com.example.massive.Information2.JagungActivity
import com.example.massive.Information2.KejuActivity
import com.example.massive.Information2.KopiActivity
import com.example.massive.Information2.SusuActivity
import com.example.massive.Information2.TehActivity
import com.example.massive.Information2.YogurtActivity
import com.example.massive.databinding.FragmentHindariBinding

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
            val intent = Intent(activity, TehActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img12.setOnClickListener{
            val intent = Intent(activity, KopiActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img13.setOnClickListener{
            val intent = Intent(activity, BijibijianActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img14.setOnClickListener{
            val intent = Intent(activity, JagungActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img15.setOnClickListener{
            val intent = Intent(activity, SusuActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img16.setOnClickListener{
            val intent = Intent(activity, KejuActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img17.setOnClickListener{
            val intent = Intent(activity, YogurtActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img18.setOnClickListener{
            val intent = Intent(activity, BerasmerahActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
        binding.img19.setOnClickListener{
            val intent = Intent(activity, GandumActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}