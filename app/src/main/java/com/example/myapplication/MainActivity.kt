package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
    }

    @SuppressLint("SetTextI18n")
    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {
            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()
            val dot = "."
            if (result == "0") {
                result = ""
            }
            if (result == dot) {
                result="0"
            }

            if (dot in number && dot in result) {//წერტილზე 2ჯერ დაჭერით ხდება ათწილადების ჩაწერა მთელი რიცხვი როცა ნულია 0
                val dot = "0"
                if (result.isNotEmpty()) {
                    result = dot
                }
            }
            resultTextView.text = result + number

        }
    }
    fun delClick(clickedView: View){
        if (clickedView is TextView){
            val result = resultTextView.text.toString()
            if (result.isEmpty()){
                resultTextView.text = ""
            }else {
                resultTextView.text = result.substring(0,result.length-1)
            }
        }
    }
        fun clearClick(clickedView: View) {
            if (clickedView is TextView) {
                var result: String = resultTextView.text.toString()
                if (result.isNotEmpty()) {
                    result = "0"
                }
                resultTextView.text = result
            }
        }

        fun operationClick(clickedView: View) {
            if (clickedView is TextView) {
                val result: String = resultTextView.text.toString()
                if (result.isNotEmpty()) {
                    this.operand = result.toDouble()
                }
                this.operation = clickedView.text.toString()
                resultTextView.text = ""
            }

        }


        @SuppressLint("SetTextI18n")
        fun equalsClick(clickedView: View) {
            if (clickedView is TextView) {
                val secondOperandText = resultTextView.text.toString()
                var secondOperand = 0.0
                if (secondOperandText.isNotEmpty()) {
                    secondOperand = secondOperandText.toDouble()
                }

                when (operation) {
                    "+" -> resultTextView.text = (operand + secondOperand).toString()
                    "-" -> resultTextView.text = (operand - secondOperand).toString()
                    "*" -> resultTextView.text = (operand * secondOperand).toString()
                    "/" -> resultTextView.text = (operand / secondOperand).toString()
                    "˄2"->resultTextView.text = operand.pow(2.0).toString()
                    "˄3"->resultTextView.text = operand.pow(3.0).toString()
                    "˄x"->resultTextView.text = operand.pow(secondOperand).toString()
                    "√"->resultTextView.text = sqrt(operand).toString()
                    "∛"->resultTextView.text = Math.cbrt(operand).toString()
                    "log"->resultTextView.text = (log10(operand)).toString()
                }
            }
        }

    }


