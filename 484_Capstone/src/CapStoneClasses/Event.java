/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapStoneClasses;

/**
 *
 * @author david
 */
public class Event {
    public int eventID;
    public String location,mileage,task,maxVolunteers;
    public int volunteerID;
    public final static int MAXEVENTS = 500;
    public static Event[] events = new Event[MAXEVENTS];
    
    public Event(){
        this.eventID = 0;
        this.location = "Location";
        this.mileage = "0";
        this.task = "task";
        this.maxVolunteers = "0";
        this.volunteerID = 0;
    }
    
    public Event(int evID,String loc,String mile,String t,String maxV,int volID){
        this.eventID = evID;
        this.location = loc;
        this.mileage = mile;
        this.task = t;
        this.maxVolunteers = maxV;
        this.volunteerID = volID;
    }
    
    //GETTERS
    public int getEventID(){
        return eventID;
    }
    public String getLocation(){
        return location;
    }
    public String getMileage(){
        return mileage;
    }
    public String getTask(){
        return task;
    }
    public String getMaxVolunteers(){
        return maxVolunteers;
    }
    public int getVolunteerID(){
        return volunteerID;
    }
    
    
    //SETTERS
    public void setEventID(int eID){
        this.eventID = eID;
    }
    public void setLocation(String locat){
        this.location = locat;
    }
    public void setMileage(String miles){
        this.mileage = miles;
    }
    public void setTask(String tas){
        this.task = tas;
    }
    public void setMaxVolunteers(String mxV){
        this.maxVolunteers = mxV;
    }
    public void setVolunteerID(int vID){
        this.volunteerID = vID;
    }
    
}
