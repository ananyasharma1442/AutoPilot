package com.example.autopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class flightBooking : AppCompatActivity() {

    private lateinit var airline: TextView
    private lateinit var arrTime: TextView
    private lateinit var depTime: TextView
    private lateinit var depApr: TextView
    private lateinit var arrApr: TextView
    private lateinit var bookbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_booking)

        airline = findViewById(R.id.airline)
        arrTime = findViewById(R.id.arrTime)
        depTime = findViewById(R.id.depTime)
        depApr = findViewById(R.id.depAirport)
        arrApr = findViewById(R.id.arrAirport)
        bookbtn = findViewById(R.id.booknowbtn)

        val extras : Bundle? = intent.extras
        val arrtimeIntent = extras?.getString("ARRTIME")
        val deptimeIntent = extras?.getString("DEPTIME")
        val airlineIntent = extras?.getString("AIRLINE")
        val arrairport = extras?.getString("ARRAIRPORT")
        val depairport = extras?.getString("DEPAIRPORT")
        airline.text = airlineIntent
        arrTime.text = arrtimeIntent
        depTime.text = deptimeIntent
        depApr.text = depairport
        arrApr.text = arrairport

        bookbtn.setOnClickListener {
            // Here the flight booked will be shifted to your flights
        }


    }
}