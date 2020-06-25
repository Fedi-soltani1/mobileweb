/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.elearning_session;
import Service.ServiceFormation;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.FormBase;
import static com.mycompany.myapp.MyApplication.fos;
import static com.mycompany.myapp.Session1.ConnectedUser;

/**
 *
 * @author Fedi Soltani
 */
public class E_learningsesson extends FormBase {
    
    static int idsession;
    Form current;
    Resources theme;
    
    public E_learningsesson(Resources theme)
    {  
        current = this;
        setTitle("Quiz");
        setLayout(BoxLayout.y());
        addSideMenu(theme);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });
        for(elearning_session es:ServiceFormation.getInstance().getAllTasks())
        {  if(es.getUser_id()==fos.getId()){

            Button bt=new Button(es.getName());
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    idsession=es.getId();
                    new quiz(theme).show();
                }
            });
            add(bt);
        }}
        Button btn=new Button("Liste des Reponses");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Listeanswers(theme).show();
            }
        });
        add(btn);
    
}
}
