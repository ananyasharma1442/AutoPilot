package com.example.autopilot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo : EditText
    private lateinit var dateEditText: EditText
    private lateinit var searchBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        editTextFrom = findViewById(R.id.editTextFrom)
        editTextTo = findViewById(R.id.editTextTo)
        searchBtn = findViewById(R.id.button)
        dateEditText = findViewById(R.id.dateEditText)

        searchBtn.setOnClickListener {
            if(editTextFrom.text.toString() == "BANGALORE" && editTextTo.text.toString()=="AHMEDABAD")
            {
                val intent = Intent(this, Flights::class.java)
                intent.putExtra("DATE",dateEditText.text.toString())
                intent.putExtra("SOURCE",editTextFrom.text.toString())
                intent.putExtra("DEST",editTextTo.text.toString())
                startActivity(intent)
            }
            else if(editTextFrom.text.toString() == "BANGALORE" && editTextTo.text.toString()=="DELHI")
            {
                Log.e("MAIN", "ollo")
                val intent2 = Intent(this, Flights::class.java)
                intent2.putExtra("DATE",dateEditText.text.toString())
                Log.e("MAIN", dateEditText.text.toString())
                intent2.putExtra("SOURCE",editTextFrom.text.toString())
                Log.e("MAIN", editTextFrom.text.toString())
                intent2.putExtra("DEST",editTextTo.text.toString())
                Log.e("MAIN", editTextTo.text.toString())
                startActivity(intent2)
            }


        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}