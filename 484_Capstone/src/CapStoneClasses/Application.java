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
public class Application {
    public int appID;
    public String aFirst,aLast,dob,experience,status,specialization;
    public int volunteerID;
    public int empID;
    protected final static int MAXAPPS = 500;
    public static Application [] apps = new Application[MAXAPPS];
    
    
    public Application(){
        this.appID = 0;
        this.aFirst = "First";
        this.aLast = "Last:";
        this.dob = "DOB";
        this.experience = "Experience";
        this.status = "status";
        this.specialization = "specialiazation";
        this.volunteerID = 0;
        this.empID = 0;
    }
    
    public Application(int appID,String aFirst,String aLast,String dob,String experience,String status,String specialization,int volunteerID,int empID){
        this.appID = appID;
        this.aFirst = aFirst;
        this.aLast = aLast;
        this.dob = dob;
        this.experience = experience;
        this.status = status;
        this.specialization = specialization;
        this.volunteerID = volunteerID;
        this.empID = empID;
    }
    
    //GETTERS
    public int getAppID(){
        return appID;
    }
    
    public String getAFirst(){
        return aFirst;
    }
    public String getALast(){
        return aLast;
    }
    public String getDOB(){
        return dob;
    }
    public String getExperience(){
        return experience;
    }
    public String getStatus(){
        return status;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getVolunteerID(){
        return volunteerID;
    }
    public int getEmpID(){
        return empID;
    }
    
    //SETTERS
    public void setAppID(int appID){
        this.appID = appID;
    }
    public void setAFirst(String first){
        this.aFirst = first;
    }
    public void setALast(String last){
        this.aLast = last;
    }
    public void setDOB(String birthDate){
        this.dob = birthDate;
    }
    public void setExperience(String exp){
        this.experience = exp;
    }
    public void setStatus(String stat){
        this.status = stat;
    }
    public void setSpecialization(String spec){
        this.specialization = spec;
    }
    public void setVolunteerID(int vID){
        this.volunteerID = vID;
    }
    public void setEmpID(int eID){
        this.empID = eID;
    }
}
