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
public class StateExitMenu implements BasicState
{

    FontLoader fontLoader = null;
    GUIButton exitButton;
    GUIButton mainMenuButton;
    private StateManager stateManager = null;

    public void init(GameContainer gc, StateManager stateManager) throws SlickException
    {
        this.stateManager = stateManager;
        fontLoader = new FontLoader("font/youre-gone/YoureGone.ttf", 128f);

        GUIMouseOverContent exitContent = new GUIMouseOverContent("Exit", "Exit!", "images/buttons/normal.png", "images/buttons/hover.png", "images/buttons/click.png");
        GUIMouseOverContent mainMenuContent = new GUIMouseOverContent("Main Menu", "Main Menu!", "images/buttons/normal.png", "images/buttons/hover.png", "images/buttons/click.png");

        exitButton = new GUIButton(gc, MainApp.WINDOW_WIDTH / 2 - exitContent.getBaseImage().getWidth(), MainApp.WINDOW_HEIGHT / 2, exitContent.getBaseImage().getWidth(), exitContent.getBaseImage().getHeight(), exitContent);
        exitButton.setFont(fontLoader.getSizedFont(12f), fontLoader.getSizedFont(18f));
        exitButton.setFontColors(java.awt.Color.yellow, java.awt.Color.yellow);

        mainMenuButton = new GUIButton(gc, MainApp.WINDOW_WIDTH / 2 + mainMenuContent.getBaseImage().getWidth(), MainApp.WINDOW_HEIGHT / 2, mainMenuContent.getBaseImage().getWidth(), mainMenuContent.getBaseImage().getHeight(), mainMenuContent);
        mainMenuButton.setFont(fontLoader.getSizedFont(12f), fontLoader.getSizedFont(18f));
        mainMenuButton.setFontColors(java.awt.Color.yellow, java.awt.Color.yellow);
    }

    public void update(GameContainer gc, int deltaTime) throws SlickException
    {
        if (exitButton.isButtonClicked())
        {
            System.exit(0);
        }        
        if(mainMenuButton.isButtonClicked())
        {
            mainMenuButton.resetButtonClicked();
            stateManager.setState(State.MENU);
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        //clears
        g.clear();
        //backgrond
        g.setBackground(new Color(103, 194, 240));
        g.setColor(Color.red);
        exitButton.render(g);
        mainMenuButton.render(g);
    }
}
