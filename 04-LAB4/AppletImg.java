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
public class AppletImg extends Applet
{
    Image img;
    
    @Override
    public void init() 
    {
        // TODO start asynchronous download of heavy resources
    }

    @Override
    public void paint (Graphics g)
    {
        img = getImage (getCodeBase(),"ALLAH.jpg");
        g.drawImage(img, 0, 0,getWidth(), getHeight(), this);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
