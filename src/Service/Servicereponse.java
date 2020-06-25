/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.user_elearning_session;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fedi Soltani
 */
public class Servicereponse {
        public ArrayList<user_elearning_session> Questions;
    
    public static Servicereponse instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private Servicereponse() {
         req = new ConnectionRequest();
    }

    public static Servicereponse getInstance() {
        if (instance == null) {
            instance = new Servicereponse();
        }
        return instance;
    }
       public ArrayList<user_elearning_session> parseTasks(String jsonText){
        try {
            Questions=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                user_elearning_session t = new user_elearning_session();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                float iduser = Float.parseFloat(obj.get("user_id").toString());
                t.setUser_id((int) iduser);
                float score = Float.parseFloat(obj.get("score").toString());
                t.setScore((int) score);
                Questions.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }

        return Questions;
    }
    
    public ArrayList<user_elearning_session> getAllTasks(){
        String url = Statics.BASE_URL+"/ListReponseMobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Questions = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Questions;
    }
   
}
