package com.mycompany.myapp;

import Entities.user;
import GUI.E_learningsesson;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import static com.codename1.ui.CN.*;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import Service.ServiceLogin;
import Service.ServiceUtil;
import GUI.SignUpController;
import GUI.quiz;
import java.util.ArrayList;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {

    ServiceUtil utilService = ServiceUtil.getInstance();
      public  static user fos = new user();
    private Form current;
    private Resources theme;
    private Form f;

    int i = 0;

    public void init(Object context) {
        Toolbar.setGlobalToolbar(true);
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");
        Controller1.theme = theme;
        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
        theme = UIManager.initFirstTheme("/theme_1");
        f = new Form();

        f.getTitleArea().setUIID("Container");
        f.setUIID("SignIn");

        f.add(new Label(theme.getImage("Logo.png"), "LogoLabel"));

        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");

        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?");
        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
                new FormBase().createLineSeparator(),
                new FloatingHint(password),
                new FormBase().createLineSeparator(),
                signIn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ArrayList<user> s;
                s = ServiceLogin.getInstance().getAllTasks(username.getText(), password.getText());
                for (int j = 0; j < s.size(); j++) {
                    fos.setId(s.get(j).getId());
                    fos.setUsername(s.get(j).getUsername());
                    fos.setPassword(s.get(j).getPassword());
                    fos.setEmail(s.get(j).getEmail());

                }
                if (s.size() > 0) {
                   // new InboxForm().show();
                    Dialog.show("Bonjour","Welcome back", new Command("OK"));
                    new E_learningsesson(theme).show();
                    

                } else {
                    Dialog.show("error", "Connection Failed", new Command("OK"));
                }

            }
        }
            );

            signUp.addActionListener ( 
                new ActionListener() {

            @Override
                public void actionPerformed
                (ActionEvent evt
                
                    ) {
                Form mainForm = new Form();
                    mainForm.setLayout(new BorderLayout());
                    mainForm.getToolbar().setHidden(true);
                    mainForm.getContentPane().removeAll();
                    SignUpController forumController = new SignUpController();
                    forumController.initialize();
                    mainForm.addComponent(BorderLayout.CENTER, forumController.getView());
                    mainForm.revalidate();
                    mainForm.show();

                }
            }

            );

            content.setScrollableY (

            true);
            f.add (content);

            signIn.requestFocus ();

            signIn.addActionListener (e  
            

            -> {
        });
            f.revalidate ();

            f.show ();

        }

    private Component showMyProfile() {
        final Container c = new Container(new BorderLayout());
        BorderLayout bl = new BorderLayout();
        bl.setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE);
        Container p = new Container(bl);
        p.addComponent(BorderLayout.CENTER, new InfiniteProgress());

        c.addComponent(BorderLayout.CENTER, p);

        return c;
    }

    public void destroy() {
    }

}
