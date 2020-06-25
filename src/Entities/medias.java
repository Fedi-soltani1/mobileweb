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
public class medias {
    private int id, user_id , choice; 
    private String name , file , type ; 

    public medias(int id, int user_id, int choice, String name, String file, String type) {
        this.id = id;
        this.user_id = user_id;
        this.choice = choice;
        this.name = name;
        this.file = file;
        this.type = type;
       
    }

    public medias() {
    }

    public medias(int user_id, int choice, String name, String file, String type) {
        this.user_id = user_id;
        this.choice = choice;
        this.name = name;
        this.file = file;
        this.type = type;
       
    }

    @Override
    public String toString() {
        return "medias{" + "id=" + id + ", user_id=" + user_id + ", choice=" + choice + ", name=" + name + ", file=" + file + ", type=" + type + '}';
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

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
}
