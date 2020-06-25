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
public class elearning_session_medias {
    private int id , medias_id ,elearningsession_id , ordre;

    public elearning_session_medias(int id, int medias_id, int elearningsession_id, int ordre) {
        this.id = id;
        this.medias_id = medias_id;
        this.elearningsession_id = elearningsession_id;
        this.ordre = ordre;
    }

    public elearning_session_medias() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedias_id() {
        return medias_id;
    }

    public void setMedias_id(int medias_id) {
        this.medias_id = medias_id;
    }

    public int getElearningsession_id() {
        return elearningsession_id;
    }

    public void setElearningsession_id(int elearningsession_id) {
        this.elearningsession_id = elearningsession_id;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @Override
    public String toString() {
        return "elearning_session_medias{" + "id=" + id + ", medias_id=" + medias_id + ", elearningsession_id=" + elearningsession_id + ", ordre=" + ordre + '}';
    }
    
}
