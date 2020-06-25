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
public class user_elearning_session {
    private int id , user_id, elearning_sessioni_id, score, time; 
    private java.lang.Boolean view , isvalid ; 
   

    public user_elearning_session() {
    }

    public user_elearning_session(int id, int user_id, int elearning_sessioni_id, int score, int time, Boolean view, Boolean isvalid) {
        this.id = id;
        this.user_id = user_id;
        this.elearning_sessioni_id = elearning_sessioni_id;
        this.score = score;
        this.time = time;
        this.view = view;
        this.isvalid = isvalid;
    }

    public user_elearning_session(int user_id, int elearning_sessioni_id, int score, int time, Boolean view, Boolean isvalid) {
        this.user_id = user_id;
        this.elearning_sessioni_id = elearning_sessioni_id;
        this.score = score;
        this.time = time;
        this.view = view;
        this.isvalid = isvalid;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getElearning_sessioni_id() {
        return elearning_sessioni_id;
    }

    public void setElearning_sessioni_id(int elearning_sessioni_id) {
        this.elearning_sessioni_id = elearning_sessioni_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    @Override
    public String toString() {
        return "user_elearning_session{" + "id=" + id + ", user_id=" + user_id + ", elearning_sessioni_id=" + elearning_sessioni_id + ", score=" + score + ", time=" + time + ", view=" + view + ", isvalid=" + isvalid + '}';
    }

   
  
    
}
