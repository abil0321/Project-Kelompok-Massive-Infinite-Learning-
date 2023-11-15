package com.example.massive

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DatePicker: DialogFragment(), DatePickerDialog.OnDateSetListener {
    private val calendar = Calendar.getInstance()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.time)
        val selectedDateBundle = Bundle()
        selectedDateBundle.putString("SELECTED_DATE", selectedDate)

        parentFragmentManager.setFragmentResult("REQUEST_KEY", selectedDateBundle)
    }
}