/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.elearning_session;
import Entities.user;
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
public class ServiceFormation {
        public ArrayList<elearning_session> Questions;
    
    public static ServiceFormation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
        public ArrayList<elearning_session> parseTasks(String jsonText){
        try {
            Questions=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                elearning_session t = new elearning_session();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setName(obj.get("name").toString());
                float iduser = Float.parseFloat(obj.get("user_id").toString());
                t.setUser_id((int)iduser);
                Questions.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }

        return Questions;
    }
    
    public ArrayList<elearning_session> getAllTasks(){
        String url = Statics.BASE_URL+"/allelearning_session";
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
      private ServiceFormation() {
         req = new ConnectionRequest();
    }

    public static ServiceFormation getInstance() {
        if (instance == null) {
            instance = new ServiceFormation();
        }
        return instance;
    }
    
}
