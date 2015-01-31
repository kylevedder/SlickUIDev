/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Kyle
 */
public class FontLoader
{

    private TrueTypeFont ttFont = null;
    private Font awtFont = null;

    public FontLoader(String fontPath, float defaultSize)
    {
        InputStream inputStream = ResourceLoader.getResourceAsStream(fontPath);

        try
        {
            awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        }
        catch (FontFormatException ex)
        {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (awtFont != null)
        {
            awtFont = awtFont.deriveFont(defaultSize); // set font size
            ttFont = new TrueTypeFont(awtFont, true);
        }
    }

    /**
     * Gets the font of the initial size.
     * 
     * Note: If loaded incorrectly, font may be null.
     *
     * @return
     */
    public TrueTypeFont getFont()
    {
        return this.ttFont;
    }

    /**
     * Gets a new sized font based on the AWT Font.
     *
     * Note: If loaded incorrectly, font may be null.
     * 
     * @param size
     * @return
     */
    public TrueTypeFont getSizedFont(float size)
    {
        if (awtFont != null)
        {
            return new TrueTypeFont(awtFont.deriveFont(32f), true);
        }
        else
        {
            return null;
        }
    }

}
