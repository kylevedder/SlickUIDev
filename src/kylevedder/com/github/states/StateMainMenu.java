/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.states;

import kylevedder.com.github.gui.FontLoader;
import kylevedder.com.github.gui.GUIButton;
import kylevedder.com.github.gui.GUIMouseOverContent;
import kylevedder.com.github.main.GameEngine;
import kylevedder.com.github.main.MainApp;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Kyle
 */
public class StateMainMenu implements BasicState
{
    FontLoader fontLoader = null;
    GUIButton button;
    private StateManager stateManager = null;
    
    
    public void init(GameContainer gc, StateManager stateManager) throws SlickException
    {        
        this.stateManager = stateManager;
        fontLoader = new FontLoader("font/expressway/expressway.ttf", 128f);
        
        GUIMouseOverContent content = new GUIMouseOverContent("Hello", "World", "images/buttons/normal.png", "images/buttons/hover.png", "images/buttons/hover.png");
        
        button = new GUIButton(gc, MainApp.WINDOW_WIDTH / 2, MainApp.WINDOW_HEIGHT / 2, content.getBaseImage().getWidth(), content.getBaseImage().getHeight(), content);
        button.setFont(fontLoader.getSizedFont(32f), fontLoader.getSizedFont(32f));
        button.setFontColors(java.awt.Color.yellow, java.awt.Color.yellow);
        button.setTextPadding(0, -5);
    }
    
    public void update(GameContainer gc, int deltaTime) throws SlickException
    {
        if (button.isButtonClicked())
        {
            button.resetButtonClicked();
            stateManager.setState(State.EXIT);
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        //clears
        g.clear();
        //backgrond
        g.setBackground(new Color(103, 194, 240));
        g.setColor(Color.red);
        button.render(g);        
    }
}
