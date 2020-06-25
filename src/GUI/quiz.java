/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.answer;
import Entities.question;
import Entities.user_elearning_session;
import static GUI.E_learningsesson.idsession;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.FormBase;
import static com.mycompany.myapp.MyApplication.fos;
import static com.mycompany.myapp.Session1.ConnectedUser;
import com.mycompany.myapp.services.ServicQuiz;

/**
 *
 * @author Fedi Soltani
 */
public class quiz extends FormBase{
    Form current;
    Resources theme;
    int score=0;
    int Timer=0;
    public quiz(Resources theme)
    {
        current = this;
        setTitle("Quiz");
      
        Timer=Timer++;
        setLayout(BoxLayout.y());
        addSideMenu(theme);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });
        
        Button submit= new Button("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                user_elearning_session ues=new user_elearning_session();
                ues.setScore(score);
                ues.setElearning_sessioni_id(idsession);
                ues.setUser_id(fos.getId());
                ues.setTime(Timer);
                ues.setView(true);
                ServicQuiz.getInstance().addanswer(ues);
                Dialog.show("Hi", "Form Submitted", new Command("OK"));
            }
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
                 cb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       if(cb1.isSelected()==true&&rep.getFlag()==true)
                        score=score+1; 
                    }
                });
               
                    answers.add(cb1);
                }
                
            }
              question.add(CENTER,ques);
              question.add(SOUTH,answers);
              
              add(question);
            }
        }
        add(submit);
        
    }
    
}
