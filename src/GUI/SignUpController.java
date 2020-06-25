/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.user;
import com.codename1.capture.Capture;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.north;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.myapp.Controller1;
import com.mycompany.myapp.MyApplication;

import java.io.IOException;

/*
 *
 * @author ASUS
 */
public class SignUpController extends Controller1 {

    private Resources theme;
    String goupeimg;
    

    public SignUpController() {
        super();

    }

    @Override
    public void initialize() {

        this.rootContainer.removeAll();
        this.rootContainer.setUIID("SignUpForm");
        this.theme = theme;
        theme = UIManager.initFirstTheme("/theme");

        Container north = new Container(new FlowLayout(Component.CENTER));
        Button photobutton = new Button("", theme.getImage("profile-photo-button.png"));
        photobutton.getIcon();
        photobutton.setUIID("SignUpPhotoButton");
        north.addComponent(photobutton);

        
         
            

        

        this.rootContainer.add(BorderLayout.NORTH, north);

        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("SignUpCenter");
        Container row1 = new Container(new GridLayout(1, 2));
        TextField firstname = new TextField();
        firstname.setHint("Nom");
        firstname.getHintLabel().setUIID("SignUpField");
        firstname.setUIID("SignUpField");
        TextField lastname = new TextField();
        lastname.setHint("Prenom");
        lastname.getHintLabel().setUIID("SignUpField");
        lastname.setUIID("SignUpField");
        row1.addComponent(firstname);
        row1.addComponent(lastname);
        center.addComponent(row1);
        center.setScrollableY(true);
        TextField email = new TextField();
        center.addComponent(email);
        email.setHint("E-mail");
        email.getHintLabel().setUIID("SignUpField");
        email.setUIID("SignUpField");
        TextField password = new TextField();
        password.setConstraint(TextField.PASSWORD);
        password.setHint("Password");
        password.getHintLabel().setUIID("SignUpField");
        password.setUIID("SignUpField");
        center.addComponent(password);

        Container row4 = new Container(new BorderLayout());
        Label code = new Label("+216");
        row4.addComponent(BorderLayout.WEST, code);
        TextField phonenumber = new TextField();
        phonenumber.setHint("Phone Number");
        phonenumber.getHintLabel().setUIID("SignUpField");
        phonenumber.setUIID("SignUpField");
        code.setUIID("SignUpField");
        row4.addComponent(BorderLayout.CENTER, phonenumber);
        center.addComponent(row4);
        this.rootContainer.add(BorderLayout.CENTER, center);

        Button getstarted = new Button("Get Started", theme.getImage("entrer.png"));
        getstarted.setUIID("SignUpButton");
        getstarted.setGap(getstarted.getStyle().getFont().getHeight());
        getstarted.setTextPosition(Component.LEFT);
        this.rootContainer.add(BorderLayout.SOUTH, getstarted);

        getstarted.addActionListener(new ActionListener() {
            Form mainForm = new Form();

            @Override
            public void actionPerformed(ActionEvent evt) {

                mainForm.setLayout(new BorderLayout());
                mainForm.getContentPane().removeAll();
                ajouter_compteController forumController = new ajouter_compteController();
                MyApplication m = new MyApplication();

                m.start();

            }

        });

        Validator valid = new Validator();
        valid.addConstraint(firstname, new LengthConstraint(1)).addConstraint(lastname, new LengthConstraint(1))
                .addConstraint(email, RegexConstraint.validEmail()).addConstraint(phonenumber, new LengthConstraint(8)).addConstraint(password, new LengthConstraint(1));
        valid.addSubmitButtons(getstarted);
        valid.setShowErrorMessageForFocusedComponent(true);
        this.rootContainer.revalidate();
    }

}
