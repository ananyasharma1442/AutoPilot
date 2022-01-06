package com.example.autopilot

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(val context: Context, val userList: ArrayList<Flight>) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {
    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val arr_time = itemView.findViewById<TextView>(R.id.arr_time)
        val dep_time = itemView.findViewById<TextView>(R.id.dep_time)
        val airline = itemView.findViewById<TextView>(R.id.airline_textView)
        val rating1 = itemView.findViewById<ImageView>(R.id.star1)
        val rating2 = itemView.findViewById<ImageView>(R.id.star2)
        val rating3 = itemView.findViewById<ImageView>(R.id.star3)
        val rating4 = itemView.findViewById<ImageView>(R.id.star4)
        val rating5 = itemView.findViewById<ImageView>(R.id.star5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightAdapter.FlightViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_item_flight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightAdapter.FlightViewHolder, position: Int) {
        val currentFlight =userList[position]
        holder.arr_time.text =currentFlight.arr_time
        holder.dep_time.text =currentFlight.dep_time
        holder.airline.text =currentFlight.airline
        if(userList[position].rating==1)
        {
            holder.rating1.setImageResource(R.drawable.full_star)
        }
        else if(userList[position].rating==2)
        {
            holder.rating1.setImageResource(R.drawable.full_star)
            holder.rating2.setImageResource(R.drawable.full_star)
        }else if(userList[position].rating==3)
        {
            holder.rating1.setImageResource(R.drawable.full_star)
            holder.rating2.setImageResource(R.drawable.full_star)
            holder.rating3.setImageResource(R.drawable.full_star)
        }else if(userList[position].rating==4)
        {
            holder.rating1.setImageResource(R.drawable.full_star)
            holder.rating2.setImageResource(R.drawable.full_star)
            holder.rating3.setImageResource(R.drawable.full_star)
            holder.rating4.setImageResource(R.drawable.full_star)
        }else{
            holder.rating1.setImageResource(R.drawable.full_star)
            holder.rating2.setImageResource(R.drawable.full_star)
            holder.rating3.setImageResource(R.drawable.full_star)
            holder.rating4.setImageResource(R.drawable.full_star)
            holder.rating5.setImageResource(R.drawable.full_star)
        }

        // set on click listener for the user to book flights here.

        holder.itemView.setOnClickListener {
            val intent = Intent(context, flightBooking::class.java)
            intent.putExtra("ARRTIME",holder.arr_time.text.toString())
            intent.putExtra("DEPTIME",holder.dep_time.text.toString())
            intent.putExtra("AIRLINE",holder.airline.text.toString())
            intent.putExtra("DEPAIRPORT",userList[position].srcAirport)
            intent.putExtra("ARRAIRPORT",userList[position].desAirport)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

}
