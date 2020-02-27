/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaemployee;

import java.util.Random;

/**
 *
 * @author Abbas Zaheer
 */
public class Employee {

    
    
    private String id;
    private String name;
    private String gender;
    private String phone_no;
    private String designation;
    
     
     
    public Employee(){}
    
    
     public Employee(String name, String gender, String phone_no, String designation) {
        this.name = name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.designation = designation;
        this.id = idGenrator(name);
        
    }
 public Employee(String id, String name, String gender, String phone_no, String designation) {
        this.id=id;
        this.name = name;
        this.gender = gender;
        this.phone_no = phone_no;
        this.designation = designation;
        
        
    }
   
     private String idGenrator(String name){
        String alpha = "";
        int beta = 0;
        int i = 0;
        while(i < 3){
            alpha += name.charAt(i);
            i++;
        }
        alpha = alpha.toUpperCase();
        Random rand = new Random();
        beta = rand.nextInt(1000);
        
        String res = alpha + beta;
        
        return res;
    }
     
    
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
   
   
}
