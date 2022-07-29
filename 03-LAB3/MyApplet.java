/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.applet.*;

/**
 *
 * @author mahmoud
 */
public class MyApplet extends Applet 

{
    int x = 50;
    Font fnt;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    
    @Override
    public void paint (Graphics g)
    {
        int style = 3;
        int size = 15;
        //String [] fNames = Toolkit.getDefaultToolkit().getFontList();
        String [] fNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        //resize(1000, 1000);
        for (String s: fNames)
        {
            fnt = (new Font(s, style, size));
            g.setFont(fnt);
            g.setColor(Color.RED);
            g.drawString("Welcome to font  "+s, 30, x);
            x+= 20;
        }
    }

    // TODO overwrite start(), stop() and destroy() methods
}
