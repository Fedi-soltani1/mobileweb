/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InfiniteProgress;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Nacef
 */
public abstract class Controller1 {
    
    protected Container rootContainer;
    public static Resources theme;
    public static String ip = "http://127.0.0.1:8000";
    
    public Controller1()
    {
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE);
        rootContainer = new Container(borderLayout);
        Container loadingContainer = new Container();
        loadingContainer.addComponent(new InfiniteProgress());
        rootContainer.addComponent(BorderLayout.CENTER, loadingContainer);
    }
    
    public abstract void initialize();
    
    public Component getView()
    {
        return rootContainer;
    }

}
