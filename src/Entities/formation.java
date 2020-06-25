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
public class formation {
    private int id, user_id , levl_id,score, timer ,enabled ;
    private String name ;

    public formation(int user_id, int levl_id, int score, int timer, int enabled, String name) {
        this.user_id = user_id;
        this.levl_id = levl_id;
        this.score = score;
        this.timer = timer;
        this.enabled = enabled;
        this.name = name;
       
    }

    
    public formation() {
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

    public int getLevl_id() {
        return levl_id;
    }

    public void setLevl_id(int levl_id) {
        this.levl_id = levl_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "formation{" + "id=" + id + ", user_id=" + user_id + ", levl_id=" + levl_id + ", score=" + score + ", timer=" + timer + ", enabled=" + enabled + ", name=" + name + '}';
    }

  

   

   
      
}
