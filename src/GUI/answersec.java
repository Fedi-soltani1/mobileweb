/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.answer;
import Entities.question;
import Entities.user_elearning_session;
import static GUI.Listeanswers.idreponse;
import Service.Servicereponse;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.FormBase;
import com.mycompany.myapp.services.ServicQuiz;

/**
 *
 * @author Fedi Soltani
 */
public class answersec extends FormBase {
     Form current;
    Resources theme;
    int  score;
    public answersec(Resources theme)
    {
        current = this;
        setTitle("Answer ");
        setLayout(BoxLayout.y());
        addSideMenu(theme);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });

        for(question q: ServicQuiz.getInstance().getAllTasks())
        {
            if(q!=null)
            {
                Container question= new Container(new BorderLayout());
                question.setUIID("question12");
                Label ques=new Label(q.getLabel());
                Container answers=new Container(BoxLayout.y());
              if(q.getAnswers()!=null){
                for (answer rep:q.getAnswers())                   
                {   CheckBox cb1 = new CheckBox(rep.getLabel());
                    if(rep.getFlag()==true)
                    cb1.setSelected(true);
                    answers.add(cb1);
                }
                
            }
              question.add(CENTER,ques);
              question.add(SOUTH,answers);
              
              add(question);
            }
        }
        for(user_elearning_session es:Servicereponse.getInstance().getAllTasks())
        { if(es.getId()==idreponse)
           score=es.getScore();
         }
        Label lb=new Label("Votre score :"+Integer.toString(score));
        lb.setUIID("question12");
        add(lb);
        
    }
    
    
}
