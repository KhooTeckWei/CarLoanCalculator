package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateLoan()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }

    }

    private fun calculateLoan() {
        val carPrice : Float =  editTextCarPrice.text.toString().toFloat()
        val downPayment : Float =  editTextDownPayment.text.toString().toFloat()
        val loanPeriod : Float =  editTextLoanPeriod.text.toString().toFloat()
        val interestRate : Float =  editTextInterestRate.text.toString().toFloat()
        var carLoan = String.format("%.2f", carPrice - downPayment)

        var interest = String.format("%.2f", carLoan.toDouble() * interestRate * loanPeriod/100)
        var repayment = String.format("%.2f", (carLoan.toDouble() + interest.toDouble())/ loanPeriod/12)

        val textLoan: TextView = findViewById(R.id.textViewLoan)
        val textInterest: TextView = findViewById(R.id.textViewInterest)
        val textMonthly: TextView = findViewById(R.id.textViewMonthlyRepayment)

        textLoan.text = "Loan: RM "+ carLoan
        textInterest.text = "Interest: RM "+ interest
        textMonthly.text = "Monthly repayment: RM "+ repayment

    }

    private fun reset(){
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextInterestRate.text = null
        editTextLoanPeriod.text = null
        textViewLoan.text = null
        textViewInterest.text = null
        textViewMonthlyRepayment.text = null
    }

}
