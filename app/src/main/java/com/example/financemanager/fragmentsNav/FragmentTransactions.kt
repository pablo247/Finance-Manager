package com.example.financemanager.fragmentsNav


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.financemanager.R
import com.example.financemanager.components.datePicker.DatePicker
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentTransactions : Fragment(), DatePicker.ChangeDatePickerListener {

    private var datePicker: DatePicker? = null
    private var calendar: Calendar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transactions, container, false)

        datePicker = view.findViewById(R.id.date_picker)
        datePicker!!.setOnChangeDatePickerListener(this)

        return view
    }

    override fun onChangeDatePicker(calendar: Calendar) {
        this.calendar = calendar
        Toast.makeText(this.context, this.calendar!!.time.toString(), Toast.LENGTH_SHORT).show()
    }

}
