package com.airlines.util;

public class Queries {
    public static final String SELECTQUERY="select * from Flight";
    public static final String INSERTQUERY="insert into Flight(flightId,flightName,source,destination,date,arrivalTime, depatureTime,price,noOfSeats)"
            + " values(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATEQUERY="update Flight set arrivalTime=?,depatureTime=? where flightId=?";
    public static final String DELETEQUERY="delete from Flight where flightId=?";

    public static final String SELECTIDQUERY="select * from Flight where flightId=?";
    public static final String SELECTNAMEQUERY="select * from Flight where flightName=?";
    public static final String SELECTALLQUERY="select * from flight where source=? and destination=?";


}
