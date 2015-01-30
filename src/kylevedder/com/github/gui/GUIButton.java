/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.gui.MouseOverArea;

/**
 *
 * @author Kyle
 */
public class GUIButton
{
    private GUIRectangle rect;
    private GUIMouseOverContent content;
    private TextField field = null;
    private MouseOverArea area = null;
    
    private GameContainer gc = null;
    

    public GUIButton(GameContainer gc, float centerX, float centerY, float width, float height, GUIMouseOverContent content)
    {
        this.gc = gc;        
        this.rect = new GUIRectangle(centerX, centerY, width, height);
        this.content = content;
        this.area = new MouseOverArea(gc, this.content.getBaseImage(), this.rect.getRectangle());
    }
    
    
    /**
     * Renders the GUIButton
     * @param g 
     */
    public void render(Graphics g)
    {
        this.area.render(gc, g);
    }
    
}
