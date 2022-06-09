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
    public String aFirst,aLast,dob,email, phone, address, experience,status;
    static public int appCount = 0;
    protected final static int MAXAPPS = 500;
    public static Application [] apps = new Application[MAXAPPS];
    
    
    public Application(){
        this.appID = 0;
        this.aFirst = null;
        this.aLast = null;
        this.dob = null;
        this.email = null;
        this.phone = null;
        this.address = null;
        this.experience = null;
        this.status = null;
        appCount++;
    }
    
    public Application(String aFirst,String aLast,String dob,String email, 
            String phone, String address, String experience){
        this.appID = appCount++;
        this.aFirst = aFirst;
        this.aLast = aLast;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.experience = experience;
        this.status = "New application";
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
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getAddress(){
        return address;
    }
    public String getExperience(){
        return experience;
    }
    public String getStatus(){
        return status;
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
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setAddress(String address){
        this.phone = address;
    }
    public void setExperience(String exp){
        this.experience = exp;
    }
    public void setStatus(String stat){
        this.status = stat;
    }
}