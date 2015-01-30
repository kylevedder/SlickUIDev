/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.gui;

import org.newdawn.slick.Image;

/**
 *
 * @author Kyle
 */
public class GUIMouseOverContent
{
    private String baseText;
    private String hoverText;
    private Image baseImage;
    private Image hoverImage;

    public GUIMouseOverContent(String baseText, String hoverText, Image baseImage, Image hoverImage)
    {
        this.baseText = baseText;
        this.hoverText = hoverText;
        this.baseImage = baseImage;
        this.hoverImage = hoverImage;
    }

    public String getBaseText()
    {
        return baseText;
    }

    public String getHoverText()
    {
        return hoverText;
    }

    public Image getBaseImage()
    {
        return baseImage;
    }

    public Image getHoverImage()
    {
        return hoverImage;
    }
    
    
    
    
}
