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
public class Volunteer {
    public int volunteerID;
    public String vFirst,vLast,email,phone,address,hours;
    public final static int MAXVOLUNTEERS = 500;
    public static Volunteer[] volunteers = new Volunteer[MAXVOLUNTEERS];
    
    public Volunteer(){
        this.volunteerID = 0;
        this.vFirst = "first";
        this.vLast = "last";
        this.email = "email";
        this.phone = "phone";
        this.address = "address";
        this.hours = "hours";
    }
    
    public Volunteer(int vID,String first,String last,String email,String phone,String address,String hours){
        this.volunteerID = vID;
        this.vFirst = first;
        this.vLast = last;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hours = hours;
    }
    
    //GETTERS
    public int getVolunteerID(){
        return volunteerID;
    }
    public String getVFirst(){
        return vFirst;
    }
    public String getVLast(){
        return vLast;
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
    public String getHours(){
        return hours;
    }
    
    
    //SETTERS
    public void setVolunteerID(int v){
        this.volunteerID = v;
    }
    public void setVFirst(String f){
        this.vFirst = f;
    }
    public void setVLast(String l){
        this.vLast = l;
    }
    public void setEmail(String e){
        this.email = e;
    }
    public void setPhone(String p){
        this.phone = p;
    }
    public void setAddress(String a){
        this.address = a;
    }
    public void setHours(String h){
        this.hours = h;
    }
    
}
