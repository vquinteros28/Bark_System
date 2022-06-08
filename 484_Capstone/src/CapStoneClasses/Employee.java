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
public class Employee {
    public int empID;
    public String eFirst,eLast,title;
    protected final static int MAXEMP = 500;
    public static Employee[] employees = new Employee[MAXEMP];
    
    public Employee(){
        this.empID = 0;
        this.eFirst = "First";
        this.eLast = "Last";
        this.title = "title";
    }
    
    public Employee(int eID,String first,String last,String title){
        this.empID = eID;
        this.eFirst = first;
        this.eLast = last;
        this.title = title;
    }
    
    //GETTERS
    public int getEmpID(){
        return empID;
    }
    public String getEFirst(){
        return eFirst;
    }
    public String getELast(){
        return eLast;
    }
    public String getTitle(){
        return title;
    }
    
    //SETTERS
    public void setEmpID(int eD){
        this.empID = eD;
    }
    public void setEFirst(String f){
        this.eFirst = f;
    }
    public void setELast(String l){
        this.eLast = l;
    }
    public void setTitle(String t){
        this.title = t;
    }
}

