package com.example.financemanager.components.datePicker

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.financemanager.R
import java.text.SimpleDateFormat
import java.util.*

class DatePicker
    @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyle: Int = 0, defStyleRes: Int = 0)
    : LinearLayout(context, attrs, defStyle, defStyleRes) {

    interface ChangeDatePickerListener {
        fun onChangeDatePicker(calendar: Calendar)
    }

    private var textDate: TextView? = null
    private var nextMonth: ImageButton? = null
    private var prevMonth: ImageButton? = null
    private val calendar: Calendar = Calendar.getInstance()

    private var changeDatePicker: ChangeDatePickerListener? = null

    init {
        LayoutInflater.from(this.context).inflate(R.layout.date_picker, this, true)
        orientation = VERTICAL

        textDate = findViewById(R.id.TextDate)
        nextMonth = findViewById(R.id.ButtonNextMonth)
        prevMonth = findViewById(R.id.ButtonPrevMonth)

        textDate!!.text = getCurrentDate()

        nextMonth!!.setOnClickListener {
            textDate!!.text = changeMonth(1)
            this.changeDatePicker!!.onChangeDatePicker(calendar)
        }

        prevMonth!!.setOnClickListener {
            textDate!!.text = changeMonth(-1)
            this.changeDatePicker!!.onChangeDatePicker(calendar)
        }
    }

    private fun getCurrentDate():String {
        return SimpleDateFormat("yyy, MMM").format(calendar.time)
    }

    private fun changeMonth(typeChange: Int): String {
        calendar.add(Calendar.MONTH, typeChange)
        return getCurrentDate()
    }

    fun setOnChangeDatePickerListener(dateListener: ChangeDatePickerListener) {
        this.changeDatePicker = dateListener
        this.changeDatePicker!!.onChangeDatePicker(calendar)
    }

}