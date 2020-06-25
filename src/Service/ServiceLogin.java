/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.user;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Session1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ISLEM_PC
 */
public class ServiceLogin {

   public ArrayList<user> fosmobi;

    public static ServiceLogin instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceLogin() {
        req = new ConnectionRequest();
    }

    public static ServiceLogin getInstance() {
        if (instance == null) {
            instance = new ServiceLogin();
        }
        return instance;
    }

    public boolean addTask(user A) {
        
        String url =  "http://localhost/projetquiz/web/app_dev.php/mobile/fos/new?username=" + A.getUsername() + "&email=" + A.getEmail() + "&password=" + A.getPassword() ; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean editTask(user A) {
        
        String url = "http://localhost/projetquiz/web/app_dev.php/mobile/fos/edit?username="+A.getUsername()+"&email="+A.getEmail()+"&password="+A.getPassword(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<user> parsefos(String jsonText) {

        try {
            fosmobi = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                user A = new user();
                float id = Float.parseFloat(obj.get("id").toString());
                A.setId((int)id);
                A.setUsername(obj.get("username").toString());
                A.setPassword(obj.get("password").toString());
                A.setEmail(obj.get("email").toString());
                
               

                fosmobi.add(A);
            }
        } catch (IOException ex) {

        }
        return fosmobi;
    }

    public ArrayList<user> getAllTasks(String username, String password) {
        String url = "http://localhost/projetquiz/web/app_dev.php/mobile/fos/cnx?username=" + username + "&password=" + password;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                fosmobi = parsefos(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return fosmobi;
    }


}
