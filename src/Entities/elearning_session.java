/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


/**
 *
 * @author Fedi Soltani
 */
public class elearning_session {
    private int id , formation_id , user_id ; 
    private String name;  

    public elearning_session(int id, int formation_id, int user_id, String name) {
        this.id = id;
        this.formation_id = formation_id;
        this.user_id = user_id;
        this.name = name;
    }

    public elearning_session() {
    }

    public elearning_session(int formation_id, int user_id, String name) {
        this.formation_id = formation_id;
        this.user_id = user_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "elearning_session{" + "id=" + id + ", formation_id=" + formation_id + ", user_id=" + user_id + ", name=" + name + '}';
    }

   

    
    
}
