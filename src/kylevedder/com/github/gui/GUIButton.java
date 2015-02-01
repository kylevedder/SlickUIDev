/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import kylevedder.com.github.main.MainApp;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
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
    
    private UnicodeFont defaultFont = null;
    private UnicodeFont hoverFont = null;
    
    private boolean buttonClicked = false;
    

    public GUIButton(GameContainer gc, float centerX, float centerY, float width, float height, GUIMouseOverContent content)
    {
        this.gc = gc;        
        this.rect = new GUIRectangle(centerX, centerY, width, height);
        this.content = content;
        this.area = new MouseOverArea(gc, this.content.getBaseImage(), this.rect.getRectangle());        
        this.area.setMouseOverImage(content.getHoverImage());        
        this.area.setMouseDownImage(content.getClickImage());
        this.defaultFont = new UnicodeFont(new JLabel().getFont());
        this.hoverFont = new UnicodeFont(new JLabel().getFont());
        this.buttonClicked = false;
        this.area.addListener(new ComponentListener()
        {

            @Override
            public void componentActivated(AbstractComponent source)
            {                    
                buttonClicked = true;
            }
        });
    }

    /**
     * Sets the defaultFont for the button.
     * @param font 
     */
    public void setFont(UnicodeFont defaultFont, UnicodeFont hoverFont)
    {
        this.defaultFont = defaultFont;
        this.hoverFont = hoverFont;
    }
    
    /**
     * Sets the font colors.
     * @param defaultColor
     * @param hoverColor 
     */
    public void setFontColors(Color defaultColor, Color hoverColor)
    {
        this.defaultFont = FontLoader.setFontColor(defaultFont, defaultColor);
        this.hoverFont = FontLoader.setFontColor(hoverFont, hoverColor);
    }

    /**
     * Checks if the button is clicked.
     * @return 
     */
    public boolean isButtonClicked()
    {
        return buttonClicked;
    }
    
    /**
     * Resets the state of the button.
     */
    public void resetButtonClicked()
    {
        buttonClicked = false;
    }
    
    
    
    /**
     * Renders the GUIButton
     * @param g 
     */
    public void render(Graphics g)
    {
        this.area.render(gc, g);
        if(this.area.isMouseOver())
        {
            this.hoverFont.drawString(
                    this.area.getX() + this.hoverFont.getWidth(this.content.getBaseText())/2, 
                    this.area.getY(), 
                    this.content.getHoverText());
        }
        else
        {
            this.defaultFont.drawString(
                    this.area.getX() + this.defaultFont.getWidth(this.content.getHoverText())/2, 
                    this.area.getY(), 
                    this.content.getBaseText());
        }        
    }
    
}
