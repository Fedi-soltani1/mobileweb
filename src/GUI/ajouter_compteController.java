/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Controller1;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ASUS
 */
public class ajouter_compteController extends Controller1 {
    
        public ajouter_compteController  ()
    {
        super();
         
    }

    @Override
    public void initialize() {
    }
    
    public void add_user(String username , String password , String nom, String email , String prenom) {
      
String hashed = BCrypt.hashpw(password, BCrypt.gensalt(13));
        System.err.println(hashed);
        
        ConnectionRequest con=new ConnectionRequest();
  
        con.setUrl(Controller1.ip +"/pimobileweb/ScriptPHP/Utilisateur/insert.php?username=" +
                username+"&email="+email+"&password=" +hashed.substring(0, 2)+"y"+hashed.substring(3)+
                "&nom=" + username +"&prenom="+prenom+"&roles=a:0:{}"+"&pass="+password);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
                public void actionPerformed(NetworkEvent evt) {
                    byte[] data = (byte[]) evt.getMetaData(); 
                    String s = new String(data);  
                    if (s.equals("success")) {
                        Dialog.show("Succés", "ajout effectué", "Ok", null);

                 
                    } 
                    else {
                      
                        Dialog.show("Echec", "Utilisateur existe deja", "Ok", null);
                        }
                }
            });
        NetworkManager.getInstance().addToQueue(con);
    }
     
     
        public void add_user1(String username , String password , String nom, String email , String prenom) {
      
String hashed = BCrypt.hashpw(password, BCrypt.gensalt(13));
        System.err.println(hashed);
        
        ConnectionRequest con=new ConnectionRequest();
  
        con.setUrl(Controller1.ip+"/Mobile/ScriptPHP/Utilisateur/insert.php?username=" + username+"&email="+email+"&password=" +hashed.substring(0, 2)+"y"+hashed.substring(3)+"&nom=" + username +"&prenom="+prenom+"&roles=a:0:{}"+"&pass="+password);

        NetworkManager.getInstance().addToQueue(con);
    }
      
        
    }


   



