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
public class StateMainMenu extends BasicState
{
    FontLoader fontLoader = null;
    GUIButton button;
    
    
    public void init(GameContainer gc) throws SlickException
    {        
        fontLoader = new FontLoader("font/youre-gone/YoureGone.ttf", 128f);
        GUIMouseOverContent content = new GUIMouseOverContent("Hello", "World", "images/buttons/normal.png", "images/buttons/hover.png", "images/buttons/click.png");
        button = new GUIButton(gc, MainApp.WINDOW_WIDTH / 2, MainApp.WINDOW_HEIGHT / 2, content.getBaseImage().getWidth(), content.getBaseImage().getHeight(), content);
        button.setFont(fontLoader.getSizedFont(12f), fontLoader.getSizedFont(14f));
        button.setFontColors(java.awt.Color.yellow, java.awt.Color.yellow);
    }
    
    public void update(GameContainer gc, int deltaTime) throws SlickException
    {
        if (button.isButtonClicked())
        {
            System.out.println("clicked");
            button.resetButtonClicked();
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
