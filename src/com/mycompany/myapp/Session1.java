/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


import Entities.user;


/**
 *
 * @author ASUS
 */
public class Session1 {
   // private int id;
    private String username;
    private String password;
    private user user;
private static Session1 session;
   
    public Session1() {
    }
  public static Session1 getInstance()
    {
        if(session == null) session = new Session1();
        return session;
    }
    
        public static user ConnectedUser = new user();

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

     
     
        public void setParameters(String username,String password)
    {
        this.username = username;
        this.password = password;
    } 
    
}
