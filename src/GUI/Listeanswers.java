/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.user_elearning_session;
import Service.Servicereponse;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.FormBase;
import static com.mycompany.myapp.MyApplication.fos;

/**
 *
 * @author Fedi Soltani
 */
public class Listeanswers extends FormBase{
    
    Form current;
    Resources theme;
    static int idreponse;
    public Listeanswers(Resources theme)
    {
        current = this;
        setTitle("Liste answers");
        setLayout(BoxLayout.y());
        addSideMenu(theme);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });
        for(user_elearning_session es:Servicereponse.getInstance().getAllTasks())
        {  if(es.getUser_id()==fos.getId()){
            Container cn=new Container();
            Label lb=new Label(String.valueOf(es.getId()));
            Button bt=new Button("See");
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    idreponse=es.getId();
                    new answersec(theme).show();
                }
            });
            add(bt);
        }}
    }
}
