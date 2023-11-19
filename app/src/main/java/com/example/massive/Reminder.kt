package com.example.massive

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.example.massive.databinding.FragmentReminderBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Reminder : Fragment(R.layout.fragment_reminder), DatePickerDialog.OnDateSetListener {
    private var _binding: FragmentReminderBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReminderBinding.bind(view)

        binding.setReminder.setOnClickListener {
            showDatePicker()
        }
    }
    private fun updateSelectedDateTime(dateTime: String) {
        binding.tvSelectedDate.text = dateTime
    }
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), this, year, month, day)
        datePickerDialog.show()
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = Calendar.getInstance()
        selectedDate.set(year, month, dayOfMonth)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = dateFormat.format(selectedDate.time)
        updateSelectedDateTime(formattedDate)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
