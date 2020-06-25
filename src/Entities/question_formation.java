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
public class question_formation {
    private int question_id, formation_id;

    public question_formation(int question_id, int formation_id) {
        this.question_id = question_id;
        this.formation_id = formation_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getFormation_id() {
        return formation_id;
    }

    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

    @Override
    public String toString() {
        return "question_formation{" + "question_id=" + question_id + ", formation_id=" + formation_id + '}';
    }

    public question_formation() {
    }
    
}
