/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.gui;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;

/**
 *
 * @author Kyle
 */
public class GUIButton
{
    private GUIRectangle rect;
    private GUIMouseOverText text;
    private TextField field = null;

    public GUIButton(float centerX, float centerY, float width, float height, GUIMouseOverText text)
    {
        this.rect = new GUIRectangle(centerX, centerY, width, height);
        this.text = text;
        
    }
    
    
    
    
}
