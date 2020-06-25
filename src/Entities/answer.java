/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Map;


/**
 *
 * @author Fedi Soltani
 */
public class answer {
    private int id , question_id; 
    private String label ; 
    private java.lang.Boolean flag , enabled; 
    

    public answer(String label) {
        this.label = label;
    }

    public answer(int id, int question_id, String label, Boolean flag, Boolean enabled ) {
        this.id = id;
        this.question_id = question_id;
        this.label = label;
        this.flag = flag;
        this.enabled = enabled;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "answer{" + "id=" + id + ", question_id=" + question_id + ", label=" + label + ", flag=" + flag + ", enabled=" + enabled + '}';
    }

   
    
    public answer() {
    }

    public answer(int id, String label, Boolean flag, Boolean enabled) {
        this.id = id;
        this.label = label;
        this.flag = flag;
        this.enabled = enabled;
        
    }
    public static answer createanswer(Map<String,Object> mapanswer)
    {
        answer a=new answer();
        a.setLabel(mapanswer.get("label").toString());
        String flag=mapanswer.get("flag").toString();
        if(flag=="true")
        a.setFlag(true);
        else
        a.setFlag(false);
        return a;
    }
   

   

  
    
}
