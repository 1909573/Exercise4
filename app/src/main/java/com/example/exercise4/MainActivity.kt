package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    var formate = SimpleDateFormat("dd MMM, YYYY", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonDate.setOnClickListener { chooseDate() }

    }


    private fun chooseDate(){
        val now = Calendar.getInstance()
        val currentYear = now.get(Calendar.YEAR)
        var year1 =0
        var month1 =0
        var date1 =0
        val datePicker = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(Calendar.YEAR,year)
            year1 = year
            selectedDate.set(Calendar.MONTH,month)
            month1 = month
            selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            date1 = dayOfMonth
            val date = formate.format(selectedDate.time)
            var age = currentYear - year1
            var minSaving = 0.0;
            var allowable = 0.0;

            if(age>=16 && age<=20){
                minSaving = 5000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=21 && age<=25){
                minSaving = 14000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=26 && age<=30){
                minSaving = 29000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=31 && age<=35){
                minSaving = 50000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=36 && age<=40){
                minSaving = 78000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=41 && age<=45){
                minSaving = 116000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=46 && age<=50){
                minSaving = 165000.0
                allowable = minSaving.toDouble()*30/100
            }
            else if(age>=51 && age<=55){
                minSaving = 228000.0
                allowable = minSaving.toDouble()*30/100
            }

            Toast.makeText(this,"Selected Date : " + date, Toast.LENGTH_SHORT).show()
            textView2.setText("Your age : " + age.toString()
            +"\nYour birthday : " + date1 + "/" + month1 + "/" + year1
            +"\nMin.Basic Saving : RM " + minSaving
            +"\nAllowable Investment : RM " + allowable)


        },
            now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
        datePicker.show()


    }
}
