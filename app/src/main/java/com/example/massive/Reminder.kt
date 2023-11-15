package com.example.massive

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentReminderBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Reminder : Fragment(R.layout.fragment_reminder) {
    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReminderBinding.bind(view)

        binding.apply {
            setReminder.setOnClickListener {
                showDatePicker()
            }
        }

        // Set up the result listener outside of the button click event
        setupResultListener()
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = formatDate(selectedYear, selectedMonth, selectedDay)
                updateSelectedDate(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun formatDate(year: Int, month: Int, day: Int): String {
        val selectedDate = Calendar.getInstance().apply {
            set(year, month, day)
        }
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        return dateFormat.format(selectedDate.time)
    }

    private fun updateSelectedDate(date: String) {
        binding.tvSelectedDate.text = date
    }

    private fun setupResultListener() {
        val supportFragmentManager = activity?.supportFragmentManager

        supportFragmentManager?.setFragmentResultListener(
            "REQUEST_DATE",
            viewLifecycleOwner
        ) { resultKey, bundle ->
            if (resultKey == "REQUEST_DATE") {
                val date = bundle.getString("SELECTED_DATE")
                binding.tvSelectedDate.text = date
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
