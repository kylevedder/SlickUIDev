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
import java.util.logging.Level;
import java.util.logging.Logger;
import kylevedder.com.github.gui.FontLoader;
import kylevedder.com.github.gui.GUIButton;
import kylevedder.com.github.gui.GUIMouseOverContent;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
        fontLoader = new FontLoader("font/youre-gone/YoureGone.ttf", 128f);
        GUIMouseOverContent content = new GUIMouseOverContent("Hello", "World", "images/buttons/normal.png", "images/buttons/hover.png", "images/buttons/click.png");
        button = new GUIButton(gc, MainApp.WINDOW_WIDTH / 2, MainApp.WINDOW_HEIGHT / 2, content.getBaseImage().getWidth(), content.getBaseImage().getHeight(), content);
        button.setFont(fontLoader.getSizedFont(12f), fontLoader.getSizedFont(14f));
        button.setFontColors(java.awt.Color.yellow, java.awt.Color.yellow);
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
        if (button.isButtonClicked())
        {
            System.out.println("clicked");
            button.resetButtonClicked();
        }
    }

    /**
     *
     * @param gc
     * @param g
     * @throws SlickException
     */
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
