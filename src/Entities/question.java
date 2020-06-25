/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;



/**
 *
 * @author Fedi Soltani
 */
public class question {
        private int id, user_id,media_id, enabled ;
        
        private String label ,type ; 

    public ArrayList<answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<answer> answers) {
        this.answers = answers;
    }
        ArrayList<answer> answers = new ArrayList<answer>();
    public question(int id, int user_id, int media_id, int enabled, String label, String type) {
        this.id = id;
        this.user_id = user_id;
        this.media_id = media_id;
        this.enabled = enabled;
        
        this.label = label;
        this.type = type;
    }

    @Override
    public String toString() {
        return "question{" + "id=" + id + ", user_id=" + user_id + ", media_id=" + media_id + ", enabled=" + enabled + ", label=" + label + ", type=" + type + '}';
    }

   
    

    public question() {
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

    public int getMedia_id() {
        return media_id;
    }

    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

 

    

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    
}
