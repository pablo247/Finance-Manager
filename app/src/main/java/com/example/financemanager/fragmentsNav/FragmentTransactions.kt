package com.example.financemanager.fragmentsNav


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.financemanager.R
import com.example.financemanager.components.datePicker.DatePicker
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentTransactions : Fragment(), DatePicker.ChangeDatePickerListener,
    AdapterView.OnItemSelectedListener {

    private var datePicker: DatePicker? = null
    private var calendar: Calendar? = null

    private var chooseTransactionDisplay: Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transactions, container, false)

        datePicker = view.findViewById(R.id.date_picker)
        datePicker!!.setOnChangeDatePickerListener(this)

        chooseTransactionDisplay = view.findViewById(R.id.spinner_choose_transactions_display)
        val adapter = ArrayAdapter.createFromResource(this.context!!, R.array.choose_transactions_display, R.layout.spinner_layout)
        adapter.setDropDownViewResource(R.layout.spinner_item_layout)
        chooseTransactionDisplay!!.adapter = adapter

        chooseTransactionDisplay!!.onItemSelectedListener = this

        return view
    }

    override fun onChangeDatePicker(calendar: Calendar) {
        this.calendar = calendar
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(this.context, "Fragmento $p2 de transacciones", Toast.LENGTH_SHORT).show()
    }

}
