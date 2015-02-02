/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kylevedder.com.github.gui.FontLoader;
import kylevedder.com.github.gui.GUIButton;
import kylevedder.com.github.gui.GUIMouseOverContent;
import kylevedder.com.github.music.MusicPlayer;
import kylevedder.com.github.states.BasicState;
import kylevedder.com.github.states.State;
import kylevedder.com.github.states.StateExitMenu;
import kylevedder.com.github.states.StateMainMenu;
import kylevedder.com.github.states.StateManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Kyle
 */
public class GameEngine
{

    public static final int WORLD_WIDTH = 40;
    public static final int WORLD_HEIGHT = 40;

    public static final int TILE_SIZE = 64;

    final float PLAYER_START_X = 500f;
    final float PLAYER_START_Y = 500f;
    final float PLAYER_START_ANGLE = 0f;

    final int TEAM_SIZE = 4;

    private float tankAngleAppend = 0;
    private float tankSpeed = 0;

    TextField field;
    TextField field2;

    FontLoader fontLoader = null;
    GUIButton button;

    public StateManager stateManager = null;
    
    public StateMainMenu mainMenu = null;
    public StateExitMenu exitMenu = null;
    public MusicPlayer musicPlayer = null;
    
    public GameEngine()
    {
        
    }

    /**
     * Sets up the game engine for use
     *
     * @param gc
     * @throws SlickException
     */
    public void init(GameContainer gc) throws SlickException
    {       
        musicPlayer = new MusicPlayer("music/Ouroboros.ogg", "music/Club_Diver.ogg");        
        mainMenu = new StateMainMenu();
        exitMenu = new StateExitMenu();
        HashMap<State, BasicState> map = new HashMap<State, BasicState>();
        map.put(State.MENU, mainMenu);
        map.put(State.EXIT, exitMenu);
        stateManager = new StateManager(State.MENU, gc, map, musicPlayer);        
        System.out.println("Game Loaded...");
    }

    /**
     * Called every update cycle for updating movement
     *
     * @param gc
     * @param deltaTime
     * @throws SlickException
     */
    public void update(GameContainer gc, int deltaTime) throws SlickException
    {
        stateManager.updateCurrent(gc, deltaTime);
    }

    /**
     *
     * @param gc
     * @param g
     * @throws SlickException
     */
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        stateManager.renderCurrent(gc, g);
    }
}
