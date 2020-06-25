package com.mycompany.myapp.services;

import Entities.answer;
import Entities.question;
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
 * @author bhk
 */
public class ServicQuiz{

    public ArrayList<question> Questions;
    
    public static ServicQuiz instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicQuiz() {
         req = new ConnectionRequest();
    }

    public static ServicQuiz getInstance() {
        if (instance == null) {
            instance = new ServicQuiz();
        }
        return instance;
    }

    public boolean addanswer(user_elearning_session ues) {
        
        String url = Statics.BASE_URL+"/addelearningusersession/"+ues.getScore() ;//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addArgument("iduser",Integer.toString(ues.getUser_id()));
        req.addArgument("sessionid",Integer.toString(ues.getElearning_sessioni_id()));
        req.addArgument("time",Integer.toString(ues.getTime()));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
             
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<question> parseTasks(String jsonText){
        try {
            Questions=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                question t = new question();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setType(obj.get("type").toString());
                t.setLabel(obj.get("label").toString());
                List<Map<String,Object>>reponse=(List<Map<String,Object>>)obj.get("answers");
                for(Map<String,Object> obj2 :reponse)
                {
                    answer a=new answer();
                    a=answer.createanswer(obj2);
                    System.out.println(a);
                    t.getAnswers().add(a);
                }
                Questions.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }

        return Questions;
    }
    
    public ArrayList<question> getAllTasks(){
        String url = Statics.BASE_URL+"/allquestion";
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
