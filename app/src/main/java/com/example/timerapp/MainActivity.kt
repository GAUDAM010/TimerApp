package com.example.timerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvTimer: TextView
    private lateinit var btnMilkTime: Button
    private lateinit var btnWaterMotorTime: Button
    private lateinit var btnToastTime: Button
    private var countDownTimer: CountDownTimer?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvTimer = findViewById(R.id.tvTimer)
        btnMilkTime = findViewById(R.id.btnMilkTime)
        btnWaterMotorTime = findViewById(R.id.btnWaterMotorTime)
        btnToastTime = findViewById(R.id.btnToastTime)

        btnMilkTime.setOnClickListener {
            startTimer(60000) // 1 minute for milk
        }

        btnWaterMotorTime.setOnClickListener {
            startTimer(120000) // 2 minutes for water motor
        }

        btnToastTime.setOnClickListener {
            startTimer(30000) // 30 seconds for toast
        }
    }

    private fun startTimer(milliseconds: Long) {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTimer.text = "Timer: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                tvTimer.text = "Timer: 0"
            }
        }.start()
    }
}