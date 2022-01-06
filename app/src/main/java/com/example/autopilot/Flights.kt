package com.example.autopilot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autopilot.databinding.ActivityFlightsBinding


private lateinit var _binding: ActivityFlightsBinding
private lateinit var flightAdapter :FlightAdapter
private lateinit var flightList : ArrayList<Flight>
private lateinit var date: TextView
private lateinit var srcAirport: TextView
private lateinit var destAirport: TextView

class Flights : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFlightsBinding.inflate(layoutInflater)
        val view= _binding.root
        setContentView(view)

        date = findViewById<TextView>(R.id.dateTextView)
        srcAirport = findViewById<TextView>(R.id.source_airport)
        destAirport = findViewById<TextView>(R.id.dest_airport)

        val extras : Bundle? = intent.extras
        date.text = extras?.getString("DATE")
        val src = extras?.getString("SOURCE")
        val dest = extras?.getString("DEST")
        Log.e("LISTEN", src+ " "+ dest)
        flightList = ArrayList()
        if(src == "BANGALORE" && dest == "AHMEDABAD")
        {
            flightList.clear()
            flightList.add(Flight("12:40", "10:10", "Indigo", 3, src, dest))
            flightList.add(Flight("18:40", "16:10", "Go Air", 4, src, dest))
            flightList.add(Flight("21:40", "19:10", "Air Asia", 5, src, dest))
        }
        else if(src == "BANGALORE" && dest == "DELHI")
        {
            flightList.clear()
            flightList.add(Flight("07:20", "05:10", "Spicejet", 2, src, dest))
            flightList.add(Flight("11:50", "09:45", "Indigo", 5, src, dest))
            flightList.add(Flight("19:10", "17:10", "Air India", 4, src, dest))
        }

        flightAdapter = FlightAdapter(this, flightList)
        _binding.flightList.layoutManager = LinearLayoutManager(this)
        _binding.flightList.adapter = flightAdapter

    }
}