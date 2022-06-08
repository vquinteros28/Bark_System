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
public class Report {
    public int reportID;
    public String summary;
    public int volunteerID,eventID,empID;
    
    
    public Report(){
        this.reportID = 0;
        this.summary = "summary";
        this.volunteerID = 0;
        this.eventID = 0;
        this.empID = 0;
    }
    
    public Report(int rID,String sum,int vID,int eID,int emID){
        this.reportID = rID;
        this.summary = sum;
        this.volunteerID = vID;
        this.eventID = eID;
        this.empID = emID;
    }
    
    //GETTERS
    public int getReportID(){
        return reportID;
    }
    public String getSummary(){
        return summary;
    }
    public int getVolunteerID(){
        return volunteerID;
    }
    public int getEventID(){
        return eventID;
    }
    public int getEmpID(){
        return empID;
    }
    
    //SETTERS
    public void setReportID(int report){
        this.reportID = report;
    }
    public void setSummary(String summ){
        this.summary = summ;
    }
    public void setVolunteerID(int voID){
        this.volunteerID = voID;
    }
    public void setEventID(int event){
        this.eventID = event;
    }
    public void setEmpID(int epID){
        this.empID = epID;
    }
}

