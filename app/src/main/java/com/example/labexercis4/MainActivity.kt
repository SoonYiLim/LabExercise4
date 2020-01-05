package com.example.labexercis4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDOB.setOnClickListener {
            getCal(it)
        }
    }

    private fun getCal(view:View)
    {
        // get saving and investment
        var saving = 0
        var investment:Double
        //get Input calendar
        val cal = Calendar.getInstance()

        //get current
        val clYear = cal.get(Calendar.YEAR)
        val clMonth = cal.get(Calendar.MONTH)
        val clDay = cal.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            txtDOB.setText(day.toString() + "-" + month.toString() + "" + year.toString())
            val CalAge = clYear- year
            when(CalAge){
                in 0..15 -> saving = 0
                in 16..20 -> saving = 5000
                in 21..25 -> saving = 14000
                in 26..30 -> saving = 29000
                in 31..35 -> saving = 50000
                in 36..40 -> saving = 78000
                in 41..45 -> saving = 116000
                in 46..50 -> saving = 165000
                in 51..55 -> saving = 228000
                else -> saving = 228000

            }
            saving.toDouble()
            investment = saving * 0.30
            age.setText(CalAge.toString())
            salary.setText(saving.toString())
            allowance.setText(investment.toString())


        }, clYear, clMonth, clDay)
        dpd.show()


    }
}
