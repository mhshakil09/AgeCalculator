package com.example.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewCalculatedAge.text = "Age: 0"
    }

    fun calculateAge(view: View){

        textViewCalculatedAge.text = "Age: 0"
        val currentDate = Calendar.getInstance().get(Calendar.DATE)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        if (editTextYear.text.isBlank() or editTextMonth.text.isBlank() or editTextDay.text.isBlank()) {

            //textViewCalculatedAge.text = "Input Year to calculate Age"
            if (editTextDay.text.isBlank()){
                editTextDay.setError("Fill up")
            }
//            else {
//                if ((editTextDay.text.toString().toInt() > 31) or (editTextDay.text.toString().toInt() < 1 )){
//                    editTextDay.setError("1 - 31")
//                }
//            }

            if (editTextMonth.text.isBlank()){
                editTextMonth.setError("Fill up")
            }
//            else{
//                if ((editTextMonth.text.toString().toInt() > 12) or (editTextMonth.text.toString().toInt() < 1 )){
//                    editTextMonth.setError("1 - 12")
//                }
//            }

            if (editTextYear.text.isBlank()){
                editTextYear.setError("Fill up")
            }
//            else{
//                if (editTextYear.text.toString().toInt() > currentYear) {
//                    textViewCalculatedAge.text = "Age cannot be negative"
//                    editTextYear.setError("Year < " + currentYear)
//                }
//            }

        }
        else if ((editTextYear.text.toString().toInt() > currentYear) or
            (editTextMonth.text.toString().toInt() > 12) or (editTextMonth.text.toString().toInt() < 1 ) or
            (editTextDay.text.toString().toInt() > 31) or (editTextDay.text.toString().toInt() < 1)){

            if ((editTextDay.text.toString().toInt() > 31) or (editTextDay.text.toString().toInt() < 1 )){
                editTextDay.setError("1 - 31")
            }

            if ((editTextMonth.text.toString().toInt() > 12) or (editTextMonth.text.toString().toInt() < 1 )){
                editTextMonth.setError("1 - 12")
            }

            if (editTextYear.text.toString().toInt() > currentYear) {
                textViewCalculatedAge.text = "Are you kidding me!!!"
                editTextYear.setError("Year <= " + currentYear)
            }

        }
        else {
//            textViewCalculatedAge.text = "Age: " + (currentYear - editTextYear.text.toString().toInt()) + ", date -> " + currentDate + ", month -> " + (currentMonth.toInt()+1) + ", year -> " + currentYear + "  " + Calendar.getInstance().time

//            textViewCalculatedAge.text = "Age: " + (currentYear - editTextYear.text.toString().toInt())

//            declaring some veriables -------------------------------------------------------------
            var extra = 0
            var calculatedDay = currentDate
            var calculatedMonth = currentMonth
            var calculatedYear = currentYear


//            calculating the Days of the Age-------------------------------------------------------
            if (editTextDay.text.toString().toInt() > currentDate ){
                extra = 1
                calculatedDay = calculatedDay + 30
            }
            calculatedDay -= editTextDay.text.toString().toInt()
//            textViewCalculatedAge.text = "Age: " + calculatedDay
////--------------------------------------------------------------------------------------------------

//            calculating the Months of the Age-----------------------------------------------------
            if (extra == 1){
                calculatedMonth = calculatedMonth - 1
                extra = 0
            }
//            if ((currentMonth < editTextMonth.text.toString().toInt()) or (currentMonth == 0)){


            if (editTextMonth.text.toString().toInt() > currentMonth){
                calculatedMonth = calculatedMonth + 12
                extra = 1
            }
            calculatedMonth = calculatedMonth - editTextMonth.text.toString().toInt()

            if (calculatedMonth < 0){
                calculatedMonth = calculatedMonth + 12
                extra = 1
            }
//            textViewCalculatedAge.text = "Age: " + calculatedMonth
////--------------------------------------------------------------------------------------------------


//            calculating the Years  of the Age-----------------------------------------------------
            if (extra == 1){
                calculatedYear = calculatedYear - 1
            }
            calculatedYear = calculatedYear - editTextYear.text.toString().toInt()
//            textViewCalculatedAge.text = "Age: " + calculatedYear
////--------------------------------------------------------------------------------------------------

//            ****** final output using some checks******


            if ((editTextYear.text.toString().toInt() == currentYear) && (editTextMonth.text.toString().toInt() > currentMonth)){
                editTextMonth.setError("This month is yet to come")
            }
            else if ((editTextYear.text.toString().toInt() == currentYear) && (editTextMonth.text.toString().toInt() == currentMonth &&
                        editTextDay.text.toString().toInt() > currentDate)){
                editTextDay.error = "This day is yet to come"
            }
            else{
                textViewCalculatedAge.text = "Age: " + calculatedYear + " years, " + calculatedMonth + " months, "+ calculatedDay + " days"
            }
////--------------------------------------------------------------------------------------------------





        }
    }
}