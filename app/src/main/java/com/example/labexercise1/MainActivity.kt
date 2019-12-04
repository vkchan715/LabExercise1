package com.example.labexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
          calculate()
      }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }
    }
    private fun calculate(){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toDoubleOrNull()
        val dwnPayment = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toDoubleOrNull()
        val rate = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDoubleOrNull()
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toDoubleOrNull()

            if(carPrice != null && dwnPayment != null && rate != null && loanPeriod != null){
            val loan = carPrice - dwnPayment
            val interest = loan * rate * loanPeriod
            val mthlyPayment = (loan + interest) / loanPeriod / 12

            findViewById<TextView>(R.id.textViewLoan).text = "Loan: "+ loan.toString()
            findViewById<TextView>(R.id.textViewInterest).text= "Interest: " + interest.toString()
            findViewById<TextView>(R.id.textViewMonthlyRepayment).text= "Monthly Repayment: " + mthlyPayment.toString()
            }
        else{
                if(carPrice == null){
                    findViewById<EditText>(R.id.editTextCarPrice).error ="Please enter a valid car price !!!"
                }
                if(dwnPayment == null){
                    findViewById<EditText>(R.id.editTextDownPayment).error="Please enter a valid down payment !!!"
                }
                if(rate == null){
                    findViewById<EditText>(R.id.editTextInterestRate).error="Please enter a valid interest rate !!!"
                }
                if(loanPeriod == null){
                    findViewById<EditText>(R.id.editTextLoanPeriod).error="Please enter a valid loan period !!!"
                }
            }
    }

    private fun reset() {
        findViewById<TextView>(R.id.textViewLoan).text = "Loan: "
        findViewById<TextView>(R.id.textViewInterest).text = "Interest: "
        findViewById<TextView>(R.id.textViewMonthlyRepayment).text = "Monthly Repayment: "

        findViewById<EditText>(R.id.editTextCarPrice).setText("")
        findViewById<EditText>(R.id.editTextDownPayment).setText("")
        findViewById<EditText>(R.id.editTextInterestRate).setText("")
        findViewById<EditText>(R.id.editTextLoanPeriod).setText("")
    }
}
