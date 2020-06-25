/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.mycompany.myapp.Controller1;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 * @author Nacef
 */
public class ServiceUtil {
    
    private static ServiceUtil utilService;
    
    private ServiceUtil(){}
    
    public static ServiceUtil getInstance()
    {
        if(utilService == null) utilService = new ServiceUtil();
        return utilService;
    }
    
    
	
    
   
}
