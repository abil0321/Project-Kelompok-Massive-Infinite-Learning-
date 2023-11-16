package com.example.massive

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentReminderBinding

class Reminder : Fragment(R.layout.fragment_reminder) {
    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!

    private val dateTimePicker = DateTimePicker()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReminderBinding.bind(view)

        binding.setReminder.setOnClickListener {
            dateTimePicker.show(requireActivity().supportFragmentManager, "dateTimePicker")
        }

        setupResultListener()
    }

    private fun updateSelectedDateTime(dateTime: String) {
        binding.tvSelectedDateTime.text = dateTime
    }

    private fun setupResultListener() {
        parentFragmentManager.setFragmentResultListener(
            "REQUEST_KEY",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_KEY") {
                val selectedDateTime = bundle.getString("SELECTED_DATE_TIME")
                updateSelectedDateTime(selectedDateTime.orEmpty())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
