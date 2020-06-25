/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import com.codename1.io.Externalizable;
import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 *@author Fedi Soltani
 */

public class user implements Serializable,Externalizable {
    private Integer id;
    private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date lastLogin;
   
    private String roles;
    private String nom;
    private String prenom;

    

    public user() {
    }

    public user(String username, String password , String email) {
        this.username = username;
        this.email = email;
      
     
        this.password = password;
    }

    public user(Integer id, String username, String email, String nom, String prenom, String image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        
    }
    
    
    
    
   
        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    

   

   

  

   
   

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof user)) {
            return false;
        }
        user other = (user) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + '}';
    }



   
   
    public static user createUser(Map<String,Object> mappedUser)
    {
        user user = new user();
        user.setId((int)Float.parseFloat(mappedUser.get("id").toString()));
        if(mappedUser.get("nom") != null)
            user.setNom(mappedUser.get("nom").toString());
        if(mappedUser.get("prenom") != null)
            user.setPrenom(mappedUser.get("prenom").toString());
       
        if(mappedUser.get("password") != null)
            user.setPassword(mappedUser.get("password").toString());
        return user;
    }

    @Override
    public int getVersion() {
        return 1 ;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(id, out);
        Util.writeObject(nom, out);
        Util.writeObject(prenom, out);
        Util.writeObject(salt, out);
      
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        id = (Integer) Util.readObject(in);
        nom = (String) Util.readObject(in);
        prenom = (String) Util.readObject(in);
        salt = (String) Util.readObject(in);
        
    }

    @Override
    public String getObjectId() {
        return "User";
    }
}
