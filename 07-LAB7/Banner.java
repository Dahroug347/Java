

import java.awt.*;
import java.applet.*;
import java.util.*;
import java.util.logging.*;


/**
 *
 * @author dahroug
 */
public class Banner extends Applet implements Runnable
{
    int size = 300;
    int style = 2;
    int x = getWidth();
      
    Thread th;
    Font fnt;
    String s = "                                                                                                 JAVA World";
    char ch;
    @Override
    public void init() 
    {
        th = new Thread(this);
        th.start();
    }

    @Override
    public void paint (Graphics b)
    { 
      fnt = (new Font(s, Font.BOLD, 300));
      b.setColor(Color.red);
      b.drawString(s,0,70);

    }
    
    
    @Override
    public void run() 
    {
        while (true)
        {                                           
            
            try 
            {
                repaint();
                Thread.sleep(50);
                ch = s.charAt(0);
                s = s.substring (1,s.length());
                s += ch;
                
            } 
            catch (InterruptedException ex) 
            {
               // Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
