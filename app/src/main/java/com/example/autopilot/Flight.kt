package com.example.autopilot

class Flight {
    var arr_time: String? = null
    var dep_time:String? = null
    var airline : String? = null
    var srcAirport : String? = null
    var desAirport : String? = null
    var rating : Int = 0

    // empty constructor
    constructor(){}


    // constructor for the flight's data
    constructor(arr_time:String? , dep_time:String?, airline:String?, rating:Int, srcAirport : String?, desAirport: String?)
    {
        this.arr_time = arr_time
        this.dep_time = dep_time
        this.airline = airline
        this.rating = rating
        this.srcAirport = srcAirport
        this.desAirport = desAirport
    }

}
