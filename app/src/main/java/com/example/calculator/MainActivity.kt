package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {
    companion object{
        val LOG = "Calculator"
    }

    lateinit var mBtn0: Button
    lateinit var mBtn1: Button
    lateinit var mBtn2: Button
    lateinit var mBtn3: Button
    lateinit var mBtn4: Button
    lateinit var mBtn5: Button
    lateinit var mBtn6: Button
    lateinit var mBtn7: Button
    lateinit var mBtn8: Button
    lateinit var mBtn9: Button
    lateinit var mBtnAddition: Button
    lateinit var mBtnMultiplication: Button
    lateinit var mBtnDivision: Button
    lateinit var mBtnSubstract: Button
    lateinit var mBtnModule: Button
    lateinit var mBtnEqual: Button
    lateinit var mBtnDot: Button
    lateinit var mBtnClear: Button
    lateinit var mBtnClearAll: Button
    lateinit var mEdtSHow: EditText

    var stringBuilder: StringBuilder = StringBuilder()
    var operator: Char = ' '
    var LEFT_HAND_SIDE: Double = 0.0
    var RIGHT_HAND_SIDE: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtn0 = findViewById(R.id.btnZero)
        mBtn1 = findViewById(R.id.btnOne)
        mBtn2 = findViewById(R.id.btnTwo)
        mBtn3 = findViewById(R.id.btnThree)
        mBtn4 = findViewById(R.id.btnFour)
        mBtn5 = findViewById(R.id.btnFive)
        mBtn6 = findViewById(R.id.btnSix)
        mBtn7 = findViewById(R.id.btnSeven)
        mBtn8 = findViewById(R.id.btnEight)
        mBtn9 = findViewById(R.id.btnNine)

        mBtnAddition = findViewById(R.id.btnAddition)
        mBtnMultiplication = findViewById(R.id.btnMutiplication)
        mBtnDivision = findViewById(R.id.btnDivision)
        mBtnSubstract = findViewById(R.id.btnSubstract)
        mBtnModule = findViewById(R.id.btnModule)
        mBtnEqual = findViewById(R.id.btnEqual)

        mBtnDot = findViewById(R.id.btnDot)

        mBtnClear = findViewById(R.id.btnClearOneAtTime)
        mBtnClearAll = findViewById(R.id.btnClearAll)

        mEdtSHow = findViewById(R.id.edtDigit)
        initlizeButton()
       // performOperation()
    }

    private fun initlizeButton() {
        numberButtonInitlize()
        operatorinitilize()
        functionalInitlize()

    }

    private fun operatorinitilize() {
        mBtnAddition.setOnClickListener {
            setOperatorToLeftHand('A')
        }
        mBtnMultiplication.setOnClickListener {
            setOperatorToLeftHand('X')
        }
        mBtnDivision.setOnClickListener {
            setOperatorToLeftHand('D')
        }
        mBtnSubstract.setOnClickListener {
            setOperatorToLeftHand('S')
        }
        mBtnModule.setOnClickListener {
            setOperatorToLeftHand('M')
        }
    }

    private fun numberButtonInitlize() {
        mBtn0.setOnClickListener {
            displayDigitToUser("0")
        }
        mBtn1.setOnClickListener {
            displayDigitToUser("1")
        }
        mBtn2.setOnClickListener {
            displayDigitToUser("2")
        }
        mBtn3.setOnClickListener {
            displayDigitToUser("3")
        }
        mBtn4.setOnClickListener {
            displayDigitToUser("4")
        }
        mBtn5.setOnClickListener {
            displayDigitToUser("5")
        }
        mBtn6.setOnClickListener {
            displayDigitToUser("6")
        }
        mBtn7.setOnClickListener {
            displayDigitToUser("7")
        }
        mBtn8.setOnClickListener {
            displayDigitToUser("8")
        }
        mBtn9.setOnClickListener {
            displayDigitToUser("9")
        }
        mBtnDot.setOnClickListener {
            displayDigitToUser(".")
        }
    }

    private fun displayDigitToUser(digit: String) {
        stringBuilder.append(digit)
        mEdtSHow.setText(stringBuilder)

    }

    private fun setOperatorToLeftHand(char:Char){
    operator = char
        LEFT_HAND_SIDE = stringBuilder.toString().toDouble()
        stringBuilder.clear()
        mEdtSHow.text = null

        Log.d(LOG,"Left hand side $LEFT_HAND_SIDE, operator: $operator")
    }

    private fun functionalInitlize(){
        mBtnClear.setOnClickListener {
            val length = stringBuilder.length
            stringBuilder.deleteCharAt(length-1)
            mEdtSHow.setText(stringBuilder)
        }
        mBtnClearAll.setOnClickListener {
            stringBuilder.clear()
            mEdtSHow.text = null
        }
        mBtnEqual.setOnClickListener {
            performOperation()
        }
    }

    private fun performOperation(){
        RIGHT_HAND_SIDE = stringBuilder.toString().toDouble()
        stringBuilder.clear()

        when(operator){
            'A' ->{
                val add = operatorhelper.add(LEFT_HAND_SIDE,RIGHT_HAND_SIDE)
                stringBuilder.append(add)
                mEdtSHow.setText(stringBuilder)
            }
            'X' ->{
                val mul = operatorhelper.mul(LEFT_HAND_SIDE,RIGHT_HAND_SIDE)
                stringBuilder.append(mul)
                mEdtSHow.setText(stringBuilder)
            }
            'M' ->{
                val mod = operatorhelper.mod(LEFT_HAND_SIDE,RIGHT_HAND_SIDE)
                stringBuilder.append(mod)
                mEdtSHow.setText(stringBuilder)
            }
            'S' ->{
                val sub = operatorhelper.sub(LEFT_HAND_SIDE,RIGHT_HAND_SIDE)
                stringBuilder.append(sub)
                mEdtSHow.setText(stringBuilder)
            }
            'D' ->{
                val div = operatorhelper.div(LEFT_HAND_SIDE,RIGHT_HAND_SIDE)
                stringBuilder.append(div)
                mEdtSHow.setText(stringBuilder)
            }

        }
    }
}